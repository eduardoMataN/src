import java.util.*;

public class randomGenerator {
    public int courses;
    public Schedule schedule;
    public SchedulingProblem problem;
    public static final double DISTANCE_PENALTY = 2.5d;
    public ArrayList<Integer> scheduledClasses = new ArrayList<Integer>();


    public randomGenerator(){

    }

    public randomGenerator(SchedulingProblem problem, Schedule solution){
        this.problem=problem;
        this.courses=problem.courses.size();
        this.schedule=solution;
    }

    public double[] generate(){
        //Index 0 is room, Index 1 is timeslot, Index 2 is Course, Index 3 is Value
        double value=0;
        double[] result={-1,-1,-1,-1};
        Random random=new Random();
        int randomClassIndex=(int) (random.nextDouble() * this.problem.courses.size());
        int randomRoomIndex=(int) (random.nextDouble() * this.problem.rooms.size());
        int randomTimeIndex=(int)(random.nextDouble()*10);
        if((this.schedule.schedule[randomRoomIndex][randomTimeIndex]<0) ||(this.schedule.schedule[randomRoomIndex][randomTimeIndex]>this.problem.rooms.size())){
            Room currentRoom=this.problem.rooms.get(randomRoomIndex);
            Course currentCourse=this.problem.courses.get(randomClassIndex);
            if(this.scheduledClasses.contains(randomClassIndex)){
                return result;
            }
            if(currentCourse.timeSlotValues[randomTimeIndex]!=0){
                value+=currentCourse.timeSlotValues[randomTimeIndex];
                value+=currentCourse.value;
                if(currentRoom.b!=currentCourse.preferredLocation){
                    Building b1 = currentRoom.b;
                    Building b2 = currentCourse.preferredLocation;
                    double xDist = (b1.xCoord - b2.xCoord) * (b1.xCoord - b2.xCoord);
                    double yDist = (b1.yCoord - b2.yCoord) * (b1.yCoord - b2.yCoord);
                    double dist = Math.sqrt(xDist + yDist);

                    value -= DISTANCE_PENALTY * dist;
                }
                result[0]=Double.valueOf(randomRoomIndex);
                result[1]=Double.valueOf(randomTimeIndex);
                result[2]=Double.valueOf(randomClassIndex);
                result[3]=value;
                scheduledClasses.add(randomClassIndex);
                
                
                
            }
        }
        return result;
    }
}
