import java.util.*;
public class population {
    int size;
    ArrayList <individual> individuals;

    public individual getFittest(){
        double max=0;
        int pos=0;
        for(int i=0;i<this.individuals.size();i++){
            if (individuals.get(i).value>max){
                max=individuals.get(i).value;
                pos=i;
            }
        }
        return this.individuals.get(pos);
    }
}


