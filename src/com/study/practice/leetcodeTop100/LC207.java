package com.study.practice.leetcodeTop100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * 《课程表》
 */
public class LC207 {
    /**
     * <拓扑排序></>：
     * 对一个有向无环图(Directed Acyclic Graph简称DAG)G进行拓扑排序，
     * 是将G中所有顶点排成一个线性序列，使得图中任意一对顶点u和v，若边(u,v)∈E(G)，
     * 则u在线性序列中出现在v之前。通常，这样的线性序列称为满足拓扑次序(Topological Order)的序列，简称拓扑序列。
     * 简单的说，由某个集合上的一个偏序得到该集合上的一个全序，这个操作称之为拓扑排序。
     * <p>
     * 解题思路：选课是要先修完之前的某个课程 这种是有先后顺序的。可以转变成《有向图中存不存在环》
     * 如果存在 则不能完成选课
     * 如果不存在 则能成功排课
     * <p>
     * 步骤：
     * 1定义一个集合用来记录每个顶点的入度和出度
     * 2定义一个集合来记录与某个顶点相连的顶点
     * 3定义一个栈,初始先将一个入度为0的顶点入栈 ，后续每次弹出栈顶元素。并将栈顶元素所连接的点的入度-1;
     * -1之后如果当前顶点的入度为0 则将当前顶点加入到栈中 。每次从栈顶弹出元素的时候,定义一个变量记录总共出栈的元素数量
     * 4如果出栈元素==课程总数 则图中不存在环 课程可以完成 反之存在环 课程不能完成。
     * 补充：没有环的情况一定是所有顶点被放进栈中 然后所有的顶点都出栈
     *
     * @param numCourses    课程数
     * @param prerequisites 学习课程的先后顺序
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // 特判如果没有先后顺序 直接成功
        if (prerequisites.length == 0) return true;

        // 栈 用于存储顶点。元素出栈的一个顺序就是一个拓扑排序次序(这个排序次序不是唯一的)
        Queue<Integer> stack = new LinkedList<>();
        // 入度数组 用于记录每次顶点的入度数
        int[] inDegree = new int[numCourses];
        // 关系集合 用于记录各个顶点之间的关系。就是某个顶点指向了那些顶点
        List<List<Integer>> list = new ArrayList<>(numCourses);
        // 记录出栈顶点的总个数 用于最后和课程总数比较
        int count = 0;

        // 初始化顶点关系集合
        for (int i = 0; i < numCourses; i++) {
            list.add(i, new ArrayList<>());
        }
/*
        遍历先修课程关系 统计每个顶点的入度数 如果存在入度数=0的 加入到栈中
        array[0] array[1]
        [1  ,       0]   0--->1  array[0]的入度+1 顶点关系是0--->指向1*/


        // 统计每个顶点的入度,统计每个顶点和它相邻的顶点
        for (int[] array : prerequisites) {
            inDegree[array[0]]++;
            // 0--->1的一个关系节点
            list.get(array[1]).add(array[0]);
        }

        // 如果存在入度为0的顶点先加入到栈中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) stack.add(i);
        }

        // 遍历栈进行统计
        while (!stack.isEmpty()) {
            Integer courseNo = stack.poll();
            // 统计出栈总的顶点数
            count++;
            // 将所有和courseNo课程相连的点的入度全部-1,并判断减一之后的入度是不是0 如果是0就加入栈中
            List<Integer> releationList = list.get(courseNo);
            for (int i = 0; i < releationList.size(); i++) {
                Integer index = releationList.get(i);
                inDegree[index] = inDegree[index] - 1;
                if (inDegree[index] == 0) stack.add(index);
            }

        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] p1 = {{1, 0}};
        System.out.println(canFinish(2, p1));

        int[][] p2 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, p2));

    }
}
