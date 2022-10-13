

public class Board {

    private Field[] fields = new Field[40];
    private static ChanceCard[] chances = new ChanceCard[3];

    /*
    * TODO:
    *   - udvid konstruktoren (jvf. Task 2.d)
    *   - tilføj statiske felter (jvf. Task 2.e, 2.f)
    *   - tilføj statisk metode (jvf. Task 2.g)
    *
    * */

    Board(String[] fielddata, String[] chancedata){
        createFields(fielddata);
        createChanceCards(chancedata);
    }
    static int index=0;
    static ChanceCard getChanceCard(){
        if(index<=3){
            ChanceCard i=chances[index];
            index++;
            return i;
        }
        else{
            index=0;
            ChanceCard i=chances[index];
            index++;
            return i;
        }
    }
    private ChanceCard[] createChanceCards(String[] data){
        for(int i =0;i < chances.length;i++){
            String s = data[i];
            String[] values = s.split(",");
            String cardtext = values[0];
            int cardIncome=Integer.parseInt(values[1]);
            int cardExpense=Integer.parseInt(values[2]);
            ChanceCard f = null;
            f = new ChanceCard(cardtext, cardIncome, cardExpense);
            chances[i]=f;
        }
        return chances;
    }
    private Field[] createFields(String[] data){
        for(int i = 0; i < fields.length; i++){
            String s = data[i];
            String[] values = s.split(",");

            int id =  Integer.parseInt(values[0]);
            String fieldtype = values[1];
            String label = values[2];
            int cost = Integer.parseInt(values[3]);
            int income = Integer.parseInt(values[4]);
            int seriesID = Integer.parseInt(values[5]);

            Field f = null;

            switch (fieldtype) {
                case "plot": f = new Plot(id, label, cost, income, seriesID);
                break;
                case "rederi":
                case "brewery": f = new Business(id, label, cost, income, seriesID);
                    break;
                case "jail": f = new Jail(id, label, cost);
                       break;
                case "visit": f = new Visit(id, label);
                    break;
                case "parking": f = new Parking(id, label);
                    break;
                case "start": f = new Start(id, label, cost, income);
                    break;
                case "lykkefelt": f = new Chance(id, label, cost, income);
                    break;
                case "tax": f = new Tax(id, label,cost, income);
                    break;

              //  default: f = new Field(id, label, cost, income);
            }

            fields[i] = f;

        }
        return fields;
    }
    public Field getField(int id) {
        id--;
        if (id < 0 || id >= fields.length) {
            return null;
        }
        return fields[id];
    }


}