package Partitioning_II_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Partitioning_II_Hard {
    public static void main(String[] args) {

        System.out.println(minCut(
                "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"));

        // System.out.println(minCut("abbadacshschhsi"));

    }

    public static boolean isPalidrone(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int minCut(String s) {
        Queue<String> bfs = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        bfs.add("0 " + s);
        while (!bfs.isEmpty()) {
            String[] curr = bfs.poll().split(" ");

            if (isPalidrone(curr[1].substring(0, curr[1].length()))) {
                return Integer.parseInt(curr[0]);
            }

            for (int j = curr[1].length(); j > 0; j--) {
                if (isPalidrone(curr[1].substring(0, j))) {
                    if (!set.contains(curr[1].substring(j, curr[1].length()))) {
                        bfs.add((Integer.parseInt(curr[0]) + 1) + " " + curr[1].substring(j, curr[1].length()));
                        set.add(curr[1].substring(j, curr[1].length()));
                    }
                }
            }
        }

        return s.length() - 1;
    }

}