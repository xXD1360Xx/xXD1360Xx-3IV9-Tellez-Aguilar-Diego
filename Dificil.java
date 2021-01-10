package juegoahorcado;

public class Dificil {

    private String dibujo;

    public String dibujoDificil(int vidas){

            switch (vidas) {
                
                case 3:
                    System.out.println(" ---------------------");
                    System.out.println(" |                     |");
                    System.out.println(" |                     |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                 | -  -  |");
                    System.out.println(" |                 |   o   |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                     |   ");
                    for (int j = 0; j < 5; j++) {
                        System.out.println(" |");

                    }
                    System.out.println("__________");
                    break;

                case 2:
                    System.out.println(" ---------------------");
                    System.out.println(" |                     |");
                    System.out.println(" |                     |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                 | -  -  |");
                    System.out.println(" |                 |   o   |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                   / |   ");
                    System.out.println(" |                 /   |   ");
                    System.out.println(" |                /    |   ");
                    System.out.println(" |                     |   ");
                    for (int j = 0; j < 5; j++) {
                        System.out.println(" |");

                    }
                    System.out.println("__________");
                    break;

                case 1:
                    System.out.println(" ---------------------");
                    System.out.println(" |                     |");
                    System.out.println(" |                     |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                 | -  -  |");
                    System.out.println(" |                 |   o   |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                   / | \\ ");
                    System.out.println(" |                  /  |   \\ ");
                    System.out.println(" |                 /   |     \\ ");
                    System.out.println(" |                     |   ");
                    for (int j = 0; j < 5; j++) {
                        System.out.println(" |");

                    }
                    System.out.println("__________");
                    break;

                case 0:
                    System.out.println(" ---------------------");
                    System.out.println(" |                     |");
                    System.out.println(" |                     |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                 | X  X  |");
                    System.out.println(" |                 |   o   |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                   / | \\ ");
                    System.out.println(" |                  /  |   \\ ");
                    System.out.println(" |                 /   |     \\ ");
                    System.out.println(" |                     |   ");
                    System.out.println(" |                    / \\");
                    System.out.println(" |                   /   \\  ");
                    System.out.println(" |                  /     \\ ");
                    for (int j = 0; j < 2; j++) {
                        System.out.println(" |");

                    }
                    System.out.println("__________");
                    System.out.println("Has perdido");
                    break;
            }
            
        
    return dibujo;
    }
    

}
    
