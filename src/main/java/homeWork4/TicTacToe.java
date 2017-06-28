package homeWork4;

import java.util.Scanner;

/**
 * Created by Dmitriy on 14.04.2017.
 */
public class TicTacToe {

    public static boolean fool(Integer[][] ar)
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(ar[i][j]==null)
                    return false;
            }
        }
        return true;
    }

    public static boolean Win(Integer[][] ar)
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                    if ((ar[0][0]!=null && ar[0][1]!= null && ar[0][2]!=null) && (ar[0][0] + ar[0][1] + ar[0][2]) == 3 ||
                            (ar[1][0]!=null && ar[1][1]!= null && ar[1][2]!=null) && (ar[1][0] + ar[1][1] + ar[1][2]) == 3 ||
                            (ar[1][0]!=null && ar[2][1]!= null && ar[2][2]!=null) && (ar[2][0] + ar[2][1] + ar[2][2]) == 3 ||

                            (ar[0][0]!=null && ar[1][0]!= null && ar[2][0]!=null) && (ar[0][0] + ar[1][0] + ar[2][0]) == 3 ||
                            (ar[0][1]!=null && ar[1][1]!= null && ar[2][1]!=null) && (ar[0][1] + ar[1][1] + ar[2][1]) == 3 ||
                            (ar[0][2]!=null && ar[1][2]!= null && ar[2][2]!=null) && (ar[0][2] + ar[1][2] + ar[2][2]) == 3 ||

                            (ar[0][0]!=null && ar[1][1]!= null && ar[2][2]!=null) && (ar[0][0] + ar[1][1] + ar[2][2]) == 3 ||
                            (ar[0][2]!=null && ar[1][1]!= null && ar[2][0]!=null) && (ar[0][2] + ar[1][1] + ar[2][0]) == 3)
                        return true;
            }
        }
        return false;
    }

    public static boolean Loose(Integer[][] ar)
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if ((ar[0][0]!=null && ar[0][1]!= null && ar[0][2]!=null) && (ar[0][0] + ar[0][1] + ar[0][2]) == 0 ||
                        (ar[1][0]!=null && ar[1][1]!= null && ar[1][2]!=null) && (ar[1][0] + ar[1][1] + ar[1][2]) == 0 ||
                        (ar[1][0]!=null && ar[2][1]!= null && ar[2][2]!=null) && (ar[2][0] + ar[2][1] + ar[2][2]) == 0 ||

                        (ar[0][0]!=null && ar[1][0]!= null && ar[2][0]!=null) && (ar[0][0] + ar[1][0] + ar[2][0]) == 0 ||
                        (ar[0][1]!=null && ar[1][1]!= null && ar[2][1]!=null) && (ar[0][1] + ar[1][1] + ar[2][1]) == 0 ||
                        (ar[0][2]!=null && ar[1][2]!= null && ar[2][2]!=null) && (ar[0][2] + ar[1][2] + ar[2][2]) == 0 ||

                        (ar[0][0]!=null && ar[1][1]!= null && ar[2][2]!=null) && (ar[0][0] + ar[1][1] + ar[2][2]) == 0 ||
                        (ar[0][2]!=null && ar[1][1]!= null && ar[2][0]!=null) && (ar[0][2] + ar[1][1] + ar[2][0]) == 0)
                    return true;
            }
        }
        return false;
    }

    public static void ComputerTurn(Integer[][] ar)
    {

        int countOfUno;
        for (int i = 0; i < 3; i++)
        {
            countOfUno = 0;
            for (int j = 0; j < 3; j++)
            {
                if(ar[i][j]!=null)
                {
                    if(ar[i][j]==1)
                    {
                       countOfUno++;
                    }
                }

            }

            if(countOfUno==2)
            {
                for(int k = 0; k<3; k++)
                {
                    if(ar[i][k]==null)
                    {
                        ar[i][k]=0;
                        return;
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 3; i++)
        {
            countOfUno = 0;
            for (int j = 0; j < 3; j++)
            {
                if(ar[j][i]!=null)
                {
                    if (ar[j][i]==1)
                    {
                        countOfUno++;
                    }
                }
            }

            if (countOfUno == 2)
            {
                for (int k = 0; k < 3; k++)
                {
                    if (ar[k][i] == null)
                    {
                        ar[k][i] = 0;
                        return;
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        countOfUno = 0;
        for (int i = 0; i < 3; i++)
        {

            if(ar[i][i]!=null)
            {
                if(ar[i][i]==1)
                {
                    countOfUno++;
                }
            }

            if(countOfUno==2)
            {
                for(int k = 0; k<3; k++)
                {
                    if(ar[k][k]==null)
                    {
                        ar[k][k]=0;
                        return;
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        countOfUno = 0;
        int iks = 0;
        int igrek = 2;
        do
        {
            if(ar[iks][igrek]!=null)
            {
                if(ar[iks][igrek]==1)
                {
                    countOfUno++;
                }

            }

            if(countOfUno==2)
            {
                int innerIks = 0;
                int innerIgrek = 2;
                do
                {
                    if(ar[innerIks][innerIgrek]==null)
                    {
                        ar[innerIks][innerIgrek]=0;
                        return;
                    }

                    innerIks++;
                    innerIgrek--;
                }
                while(true);
            }
            iks++;
            igrek--;
        }
        while(iks<3 & igrek>=0);

/////////////////////////////////////////////////////////////////////////////////////////
        for(int i=0; i<3; i++)          // что делать когда нечего блокировать
        {
            for (int j = 0; j < 3; j++)
            {
                if (ar[i][j] == null)
                {
                    ar[i][j] = 0;
                    return;
                }
            }
        }

        return;

    }

    public static void PlayerTurn(Integer[][] ar)
    {
        int x;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату Х: ");
        String xStr = scanner.nextLine();
        x = Integer.parseInt(xStr);

        int y;
        System.out.println("Введите координату У: ");
        String yStr = scanner.nextLine();
        y = Integer.parseInt(yStr);

        ar[x][y]=1;
    }

    public static void ShowMap(Integer[][] ar)
    {
        System.out.println(ar[0][0] + "|" + ar[0][1]+ "|" + ar[0][2]);
        System.out.println("=====");
        System.out.println(ar[1][0] + "|" + ar[1][1]+ "|" + ar[1][2]);
        System.out.println("=====");
        System.out.println(ar[2][0] + "|" + ar[2][1]+ "|" + ar[2][2]);
    }

    public static void main(String[] args)
    {
        Integer map[][] = new Integer[3][3]; //что бы был null вместо 0



       while(true)
        {
            PlayerTurn(map);
            ShowMap(map);

            if(Win(map)==true)
            {
                System.out.println("Ты победил!!!");
                break;
            }

            if(Loose(map)==true)
            {
                System.out.println("Ты проиграл!!!");
                break;
            }

            System.out.println();

            ComputerTurn(map);
            ShowMap(map);

            if(Win(map)==true)
            {
                System.out.println("Ты победил!!!");
                break;
            }

            if(Loose(map)==true)
            {
                System.out.println("Ты проиграл!!!");
                break;
            }

            System.out.println();

            if(fool(map)==true)
            {
                System.out.println("Ничья");
                break;
            }

        }
    }
}


























































/*Склад старых функций которые жалко удалять*/



                    /*if((ar[0][0]+ar[0][1]+ar[0][2])==3 ||
                        (ar[1][0]+ar[1][1]+ar[1][2])==3||
                            (ar[2][0]+ar[2][1]+ar[2][2])==3 ||

                            (ar[0][0]+ar[1][0]+ar[2][0])==3||
                            (ar[0][1]+ar[1][1]+ar[2][1])==3||
                            (ar[0][2]+ar[1][2]+ar[2][2])==3||

                            (ar[0][0]+ar[1][1]+ar[2][2])==3 ||
                            (ar[0][2]+ar[1][1]+ar[2][0])==3)
                        return true;


        map[0][1]=1;
       if(map[0][0]!=null && map[0][1]!= null && map[0][2]!=null && ((map[0][0]+map[0][1]+map[0][2])==3))
           System.out.println("It\'s work");
        else
           System.out.println("It\'s fine");






                        */



                    /*
        //Горизонталь
        if (ar[0][0] != null & ar[0][2] != null & ar[0][1] == null) {
            ar[0][1] = 0;
            return;
        } else if (ar[1][0] != null & ar[1][2] != null & ar[1][1] == null) {
            ar[1][1] = 0;
            return;
        } else if (ar[2][0] != null & ar[2][2] != null & ar[2][1] == null) {
            ar[2][1] = 0;
            return;
        }

        //Вертикаль
        if (ar[0][0] != null & ar[2][0] != null & ar[1][0] == null) {
            ar[1][0] = 0;
            return;
        } else if (ar[0][1] != null & ar[2][1] != null & ar[1][1] == null) {
            ar[1][1] = 0;
            return;
        } else if (ar[0][2] != null & ar[2][2] != null & ar[1][2] == null) {
            ar[1][2] = 0;
            return;
        }

        //Диагональ
        if ((ar[0][0] != null & ar[2][2] != null & ar[1][1] == null) || (ar[0][2] != null & ar[2][0] != null & ar[1][1] == null)) {
            ar[1][1] = 0;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ar[i][j] == null) {
                        ar[i][j] = 0;
                        return;
                    }
                }
            }
        }*/




                            /*
        Integer zero = new Integer(0);

        int count;
        for (int i = 0; i < 3; i++)                 //должно заменить и улучшить прохождение горизонталей
        {
            count = 0;
            for (int j = 0; j < 3; j++) {

                if(ar[i][j]==zero)
                {
                    count = 0;
                    break;
                }
                if (ar[i][j] == null) {
                    count++;
                }

            }

            if (count == 1) {
                for (int k = 0; k < 3; k++) {
                    if(ar[i][k]==zero)
                    {
                        break;
                    }

                    if (ar[i][k] == null) {
                        ar[i][k] = 0;
                        return;
                    }
                }
            }
        }

        int countVert;
        for (int i = 0; i < 3; i++)                    //Должно упростить проход по вертикалям и улучшить его
        {
            countVert = 0;
            for (int j = 0; j < 3; j++) {

                if(ar[j][i]==zero)
                {
                    countVert = 0;
                    break;
                }

                if (ar[j][i] == null) {
                    countVert++;
                }
            }

            if (countVert == 1) {
                for (int k = 0; k < 3; k++) {
                    if(ar[k][i]==zero)
                    {
                        break;
                    }

                    if (ar[k][i] == null) {
                        ar[k][i] = 0;
                        return;
                    }
                }
            }
        }


        int countDiag = 0;
        for (int i = 0; i < 3; i++)              //Должно упростить проход по ЛВ-ПН диагонали и удучшить его
        {

            if(ar[i][i]==zero)
            {
                countDiag = 0;
                break;
            }

            if(ar[i][i]==null)
            {
                countDiag++;
            }

            if(countDiag==1)
            {
                for(int k = 0; k<3; k++)
                {
                    if(ar[k][k]==zero)
                    {
                        break;
                    }

                    if(ar[k][k]==null)
                    {
                        ar[k][k]=0;
                        return;
                    }
                }
            }
        }

        int countReverseDiag = 0;
        int iks = 0;
        int igrek = 2;
        do                                         //Должно упростить проход по ПВ-ЛН диагонали и упростить его
        {
            if(ar[iks][igrek]==zero)
            {
                countReverseDiag = 0;
                break;
            }


            if(ar[iks][igrek]==null)
            {
                countReverseDiag++;
            }

            if(countReverseDiag==1)
            {
                int innerIks = 0;
                int innerIgrek = 2;
                do
                {
                    if(ar[innerIks][innerIgrek]==zero)
                    {
                        break;
                    }

                    if(ar[innerIks][innerIgrek]==null)
                    {
                        ar[innerIks][innerIgrek]=0;
                        return;
                    }
                }
                while(true);
            }
            iks++;
            igrek--;
        }
        while(iks<3 & igrek>=0);

        for(int i=0; i<3; i++)          // что делать когда нечего блокировать
        {
            for(int j = 0; j<3; j++)
            {
                if(ar[i][j]==null)
                {
                    ar[i][j]=0;
                    return;
                }
            }
        }*/