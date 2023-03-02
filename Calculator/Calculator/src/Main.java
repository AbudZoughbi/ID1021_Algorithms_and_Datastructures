public class Main {
    public static void main(String[] args){
        Item[] expr = new Item[1000];
       /* v[0] = new Item(ItemType.VALUE, 3);
        v[1] = new Item(ItemType.VALUE, 4);
        v[2] = new Item(ItemType.ADD, 0);
        v[3] = new Item(ItemType.VALUE, 2);
        v[4] = new Item(ItemType.VALUE, 4);
        v[5] = new Item(ItemType.ADD, 7);
        v[6] = new Item(ItemType.MUL, 6);
        //v[7] = new Item(ItemType.VALUE, 1);
        //v[8] = new Item(ItemType.VALUE, 5);
        */

        Item[] exp = new Item[25];

        Item nb1 = new Item(ItemType.VALUE, 0);
        Item nb2 = new Item(ItemType.VALUE, 1);
        Item nb3 = new Item(ItemType.VALUE, 0);
        Item nb4 = new Item(ItemType.VALUE, 7);
        Item nb5 = new Item(ItemType.VALUE, 2);
        Item nb6 = new Item(ItemType.VALUE, 7);
        Item nb7 = new Item(ItemType.VALUE, 6);
        Item nb8 = new Item(ItemType.VALUE, 1);
        Item nb9 = new Item(ItemType.VALUE, 5);
//        Item nb10 = new Item(ItemType.VALUE, 0);
        Item op = new Item(ItemType.SPECMUL, 0);
        Item add = new Item(ItemType.ADD,0);

        exp[0]  = new Item(ItemType.VALUE,10);
        exp[1]  = nb1;
        exp[2]  = op;
        exp[3]  = nb2;
        exp[4]  = nb3;
        exp[5]  = op;
        exp[6]  = nb4;
        exp[7]  = nb5;
        exp[8]  = op;
        exp[9]  = nb6;
        exp[10]  = nb7;
        exp[11] = op;
        exp[12] = nb8;
        exp[13] = nb9;
        exp[14] = op;
        exp[15] = add;
        exp[16] = add;
        exp[17] = add;
        exp[18] = add;
        exp[19] = add;
        exp[20] = add;
        exp[21] = add;
        exp[22] = add;
        exp[23] = new Item(ItemType.MOD, 0);
        exp[24] = new Item(ItemType.SUB, 0);

        Calculator calc = new Calculator(exp);
        System.out.println(calc.run());
/*
        Item i1 = new Item(ItemType.VALUE, 2);
        Item i2 = new Item(ItemType.ADD, 0);

        for(int i = 0; i < 500; i++){
            expr[i] = i1;
        }

        for(int i = 500; i < 1000; i++){
            expr[i] = i2;
        }

        Calculator TI82 = new Calculator(exp);
        long t0 = System.nanoTime();
        System.out.println(TI82.run()); 
        long t1 = System.nanoTime();
        System.out.println(t1-t0 + " ns");
*/
    }
}
