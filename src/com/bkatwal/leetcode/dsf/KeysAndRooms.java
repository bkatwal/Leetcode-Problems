package com.bkatwal.leetcode.dsf;

import com.bkatwal.leetcode.util.DFS;
import com.bkatwal.leetcode.util.Graph;
import java.util.List;

/**
 * 841. Keys and Rooms
 * <p>
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
 * and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0,
 * 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 */
@DFS
@Graph
public class KeysAndRooms {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    if (rooms == null) {
      return true;
    }

    boolean[] visited = new boolean[rooms.size()];

    MyInt myInt = new MyInt();

    dfs(rooms, visited, myInt, 0);

    return myInt.count == rooms.size();
  }

  private void dfs(List<List<Integer>> rooms, boolean[] visited, MyInt myInt, int current) {

    if (visited[current]) {
      return;
    }

    visited[current] = true;
    myInt.count++;

    List<Integer> keys = rooms.get(current);

    for (int key : keys) {
      dfs(rooms, visited, myInt, key);
    }
  }

  class MyInt {

    int count;
  }
}
