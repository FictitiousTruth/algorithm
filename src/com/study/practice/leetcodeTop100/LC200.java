package com.study.practice.leetcodeTop100;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * 《岛屿数量》
 */
public class LC200 {

    /**
     * 解题思路：DFS深度搜索
     * 1从第一个元素开始遍历 如果当前元素是1(陆地) 那么久开始搜索当前节点左 右 上 下 紧紧关联的四个格子
     * 2判断这四个格子是不是1 如果是1 说明可以和当前元素构成岛屿(并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。)
     * 后续再以这个元素紧邻的四个格子 进行深度搜索
     * 3对已经遍历过的格子 (能被遍历的格子一定是1 陆地)遍历过以后 将它置成0
     *
     * @param grid 陆地和水组成的二维网格
     * @return 岛屿的数量
     */
    public static int numIslands(char[][] grid) {
        // 岛屿数量
        int num = 0;
        // 二维网格的长度
        int length = grid[0].length;
        // 二维网格的宽度
        int width = grid.length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {

                /**
                 *  当前被遍历的格子是陆地 接着就将这个元素置成已经遍历过 0
                 *  然后去找当前元素四周的元素 深度搜索下去
                 */
                if (grid[i][j] == '1') {
                    // 岛屿数量加一
                    num++;
                    // 深度搜索和这个岛屿四周关联的岛屿
                    // !!!!!注意在深度搜索的时候 一定是将坐标传进去
                    // dfs(grid[i][j]) 后续对于不合理的坐标是会产生下标越界
                    dfs(i, j, grid);
                }

            }
        }
        return num;
    }

    /**
     * 以当前元素为中心 深度搜索四周的元素
     *
     * @param i    当前元素的横坐标
     * @param j    当前元素的纵坐标
     * @param grid l陆地和水域组成的二维网格
     */
    private static void dfs(int i, int j, char[][] grid) {

        // 超出二维网格的不合理的元素坐标
        // 如果当前元素横坐标>宽度-1  纵坐标>长度-1 都是会产生数组下表越界的 都是不合理的坐标
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) return;

        // 表示当前已经被搜索过
        if (grid[i][j] == '1') {
            grid[i][j] = '0';

            // 深度去搜当前格子紧邻的上方格子
            dfs(i - 1, j, grid);
            // 下
            dfs(i + 1, j, grid);
            // 左
            dfs(i, j - 1, grid);
            // 右
            dfs(i, j + 1, grid);
        }

    }

    public static void main(String[] args) {
        char[][] nums = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(nums));
    }

}