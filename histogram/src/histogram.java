

    import java.util.Deque;
    import java.util.LinkedList;

    public class histogram {

        public int histogram(int input[]){
            Deque<Integer> stack = new LinkedList<Integer>();
            int maxArea = 0;
            int area = 0;
            int i;
            for(i=0; i < input.length;){
                if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                    stack.offerFirst(i++);
                }else{
                    int top = stack.pollFirst();
                    //if stack is empty means everything till i has to be
                    //greater or equal to input[top] so get area by
                    //input[top] * i;
                    if(stack.isEmpty()){
                        area = input[top] * i;
                    }
                    //if stack is not empty then everythin from i-1 to input.peek() + 1
                    //has to be greater or equal to input[top]
                    //so area = input[top]*(i - stack.peek() - 1);
                    else{
                        area = input[top] * (i - stack.peekFirst() - 1);
                    }
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
            // Stack might not be empty so exhaust the stack
            while(!stack.isEmpty()){
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everything from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
            return maxArea;
        }

        public static void main(String args[]){
            histogram mh = new histogram();
            int input[] = {6,2,5,4,5,1,6 };
            int maxArea = mh.histogram(input);
            System.out.println(maxArea);
            assert maxArea == 12;
        }
    }

