package com.arjun.algorithms.b_tree;

public class BTree {
  public static void main(String args[]) {
    BTreeNode tree = new BTreeNode(3, false);
    BTreeNode childTree = new BTreeNode(1, true);
    childTree.insertNonFull(10);
    tree.insertNonFull(20);
    tree.insertNonFull(5);
    tree.insertNonFull(6);
    tree.insertNonFull(12);
    tree.insertNonFull(30);
    tree.insertNonFull(7);
    tree.insertNonFull(17);
    tree.insertNonFull(15);
    tree.insertNonFull(16);
    tree.insertNonFull(27);
    tree.insertNonFull(37);
    tree.insertNonFull(8);
    tree.insertNonFull(9);
    tree.insertNonFull(11);
    tree.insertNonFull(13);
    tree.insertNonFull(14);
    tree.insertNonFull(18);
    tree.insertNonFull(19);
    tree.insertNonFull(21);
    tree.insertNonFull(22);
    tree.insertNonFull(23);
    tree.insertNonFull(24);
    tree.insertNonFull(25);
    tree.insertNonFull(26);
    tree.insertNonFull(28);
    tree.insertNonFull(29);
    tree.insertNonFull(31);
    tree.insertNonFull(32);
    tree.insertNonFull(33);
    tree.insertNonFull(34);
    tree.insertNonFull(35);
    tree.insertNonFull(36);
    tree.insertNonFull(38);
    tree.insertNonFull(39);
    tree.insertNonFull(40);
    tree.insertNonFull(41);
    tree.insertNonFull(42);
    tree.insertNonFull(43);
    tree.insertNonFull(44);
    tree.insertNonFull(45);
    tree.insertNonFull(46);
    tree.insertNonFull(47);
    tree.insertNonFull(48);
    tree.insertNonFull(49);
    tree.insertNonFull(50);
    tree.insertNonFull(51);
    tree.insertNonFull(52);
    tree.insertNonFull(53);
    tree.insertNonFull(54);
    tree.insertNonFull(55);
    tree.insertNonFull(56);
    tree.insertNonFull(57);
    tree.insertNonFull(58);
    tree.insertNonFull(59);
    tree.insertNonFull(60);
    tree.insertNonFull(61);
    tree.insertNonFull(62);
    tree.insertNonFull(63);
    tree.insertNonFull(64);
    tree.insertNonFull(65);
    tree.insertNonFull(66);
    tree.insertNonFull(67);
    tree.insertNonFull(68);
    tree.insertNonFull(69);
    tree.insertNonFull(70);
    tree.insertNonFull(71);
    tree.insertNonFull(72);
    tree.insertNonFull(73);
    tree.insertNonFull(74);
    tree.insertNonFull(75);
    tree.insertNonFull(76);
    tree.insertNonFull(77);
    tree.insertNonFull(78);
    tree.insertNonFull(79);
    tree.insertNonFull(80);
    tree.insertNonFull(81);
    tree.insertNonFull(82);
    tree.insertNonFull(83);
    tree.insertNonFull(84);
    tree.insertNonFull(85);

    tree.traverse();

    var n = tree.search(10);
    System.out.println(n.keys[0]);
  }
}

class BTreeNode {
  int[] keys;
  int t;
  BTreeNode[] children;
  int n;
  boolean leaf;

  public BTreeNode(int t, boolean leaf) {
    this.t = t;
    this.leaf = leaf;
    this.keys = new int[2 * t - 1];
    this.children = new BTreeNode[2 * t];
    this.n = 0;
  }

  public void traverse() {
    int i;
    for (i = 0; i < n; i++) {
      if (!leaf) {
        children[i].traverse();
      }
      System.out.print(keys[i] + " ");
    }
    if (!leaf) {
      children[i].traverse();
    }
  }

  public BTreeNode search(int k) {
    int i = 0;
    while (i < n && k > keys[i]) {
      i++;
    }
    if (keys[i] == k) {
      return this;
    }
    if (leaf) {
      return null;
    }
    return children[i].search(k);
  }

  public void insertNonFull(int k) {
    int i = n - 1;
    if (leaf) {
      while (i >= 0 && k < keys[i]) {
        keys[i + 1] = keys[i];
        i--;
      }
      keys[i + 1] = k;
      n = n + 1;
    } else {
      // Find the child to insert the new data
      while (i >= 0 && k < keys[i]) {
        i--;
      }
      // Check if the child is full
      if (children[i + 1].n == 2 * t - 1) {
        splitChild(i + 1, children[i + 1]);
        if (k > keys[i + 1]) {
          i++;
        }
      }
      // Recursively insert the data into the appropriate child
      children[i + 1].insertNonFull(k);
    }
  }

  public void splitChild(int i, BTreeNode y) {
    BTreeNode z = new BTreeNode(y.t, y.leaf);
    z.n = t - 1;
    for (int j = 0; j < t - 1; j++) {
      z.keys[j] = y.keys[j + t];
    }
    if (!y.leaf) {
      for (int j = 0; j < t; j++) {
        z.children[j] = y.children[j + t];
      }
    }
  }
}
