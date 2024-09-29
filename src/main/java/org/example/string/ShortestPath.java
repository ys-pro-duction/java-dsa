package org.example.string;

public class ShortestPath {
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        double sortestPathInt = shortestPath(path);
        System.out.println("Path "+sortestPathInt);
    }

    /**
     * O(n)
     * @param path
     * @return
     */
    private static double shortestPath(String path){
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'E' -> x++;
                case 'W' -> x--;
                case 'N' -> y++;
                case 'S' -> y--;
            }
        }
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
}
