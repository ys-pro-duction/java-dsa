package org.example.graph;

import java.util.*;

public class CourseScheduleTwo {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        int[] result = new CourseScheduleTwo().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        int[] inDeg = new int[numCourses];
        for (int[] c : prerequisites) {
            graph.putVertex(c[1], c[0], 0);
            inDeg[c[0]]++;
        }

        graph.print();
        System.out.println(Arrays.toString(inDeg));

        int[] result = new int[numCourses];
        int resultIdx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
//                result[resultIdx++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int idx = queue.remove();
            result[resultIdx++] = idx;
            for (Graph.Edge e : graph.getEdge(idx)) {
                inDeg[e.dest()]--;
                if (inDeg[e.dest()] == 0)queue.add(e.dest());
            }
        }
        return resultIdx == numCourses ? result : new int[]{};
    }
}
