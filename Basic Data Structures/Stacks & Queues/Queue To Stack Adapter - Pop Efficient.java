import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      //o(1)
      return mainQ.size();
    }

    void push(int val) {
      //o(n) push costly
      int mainQSize = mainQ.size();
      for (int i = 0; i < mainQSize; ++i) {
        int tempData = mainQ.remove();
        helperQ.add(tempData);
      }
      mainQ.add(val);
      int helperQSize = helperQ.size();
      for (int i = 0; i < helperQSize; ++i) {
        int tempData = helperQ.remove();
        mainQ.add(tempData);
      }
    }

    int pop() {
      //o(1) pop efficient
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return mainQ.remove();
    }

    int top() {
      //o(1)
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return mainQ.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}
