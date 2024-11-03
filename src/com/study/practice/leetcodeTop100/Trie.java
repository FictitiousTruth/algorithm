package com.study.practice.leetcodeTop100;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * 《实现 Trie (前缀树)》
 * 数组+链表进行实现
 */
public class Trie {

    private TrieNode root;

    class TrieNode {
        // 当前位置是否是终点，当一个单词到达终点的时候，这个地方就是true
        private boolean isEnd;
        // 当前缀树节点的下一个前缀树节点
        private TrieNode[] nextTrieNode;

        private TrieNode() {
            isEnd = false;
            nextTrieNode = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            // 如果当前节点已经开辟了 就不能再重新赋值了
            if (current.nextTrieNode[index] == null) {
                current.nextTrieNode[index] = new TrieNode();
            }
            current = current.nextTrieNode[index];
        }
        // 一个单词的终结,从上往下找表示能组成一个单词
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.nextTrieNode[index] == null) {
                return false;
            }
            current = current.nextTrieNode[index];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.nextTrieNode[index] == null) {
                return false;
            }
            current = current.nextTrieNode[index];
        }
        return true;
    }
}

class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));

    }
}

