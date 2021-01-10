package juegoahorcado;

public class Medio {

    private String dibujo;

    public String dibujoMedio(int vidas){

            switch (vidas) {

                case 5:
                    System.out.println(" ---------------------");
                        System.out.println(" |                     |");
                        System.out.println(" |                     |");
                        System.out.println(" |                  -------");
                        System.out.println(" |                 | -  -  |");
                        System.out.println(" |                 |   o    |");
                        System.out.println(" |                  -------");
                        for (int j = 0; j < 10; j++) {
                            System.out.println(" |");
                        }
                        System.out.println("__________");
                        break;

                
                
                
                case 4:
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

                case 3:
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

                case 2:
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
                System.out.println(" |                    /  ");
                System.out.println(" |                   /      ");
                System.out.println(" |                  /       ");
                for (int j = 0; j < 2; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;   
                    
     
                case 0:
                    System.out.println(" ---------------------");
                    System.out.println(" |                     |");
                    System.out.println(" |                     |");
                    System.out.println(" |                  -------");
                    System.out.println(" |                 | x  x  |");
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