package skill.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */
class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        int min = minStack.getMin();
        int top = minStack.top();
        minStack.pop();
        min = minStack.getMin();
        System.out.println(min);
    }

    Stack<Integer> stack;

    HashMap<Integer, Integer> numToCount;

    PriorityQueue<Integer> priorityQueue;

    public MinStack() {
        stack = new Stack<>();
        priorityQueue = new PriorityQueue<>();
        numToCount = new HashMap<>();
    }

    public void push(int val) {
        stack.push(val);
        Integer num = numToCount.getOrDefault(val, 0);
        numToCount.put(val, num + 1);
        priorityQueue.add(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        numToCount.put(pop, numToCount.get(pop) - 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int poll;
        do {
            poll = priorityQueue.peek();
            if (numToCount.get(poll) == 0) {
                priorityQueue.poll();
            }
        } while (numToCount.get(poll) == 0);
        return poll;
    }
}