package com.leon.android.sinformation;


import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    import android.view.Menu;
    import android.view.MenuItem;

    import com.leon.android.sinformation.R;

    import java.rmi.RemoteException;
    import java.util.ArrayList;
    import java.util.List;

    public class IterateOverArray {


        static List<Integer> list = new ArrayList<Integer>();
        static int[] temp;
        public static void main(String[] args) throws Exception {

            list.clear();
            list.add(3);
            list.add(2);
            list.add(1);
            getScore();
        }

        public static void getScore() throws RemoteException {

            temp = new int[3];

            for (Integer value : list) {
                for (int i = 0; i < temp.length; i++) {
                    temp[i] += value.intValue();
                }
                if (temp[0] == 3) {
                    SCORE++;
                }
                if (temp[1] == 2) {
                    SCORE++;
                }
                if (temp[2] == 1) {
                    SCORE++;
                }
            }
            System.out.println("total score: " + SCORE); // Final Score should be 3!
        }
    }


}
