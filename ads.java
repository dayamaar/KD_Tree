/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author RCOEM
 */

class Node{
    int data[];
    Node left,right;
    Node(int k){
        data=new int[k];
        left=right=null;
    }
    
     static Node node_Creation(int data[]){
         Node temp=new Node(3);
         for(int i=0;i<3;i++){
             temp.data[i]=data[i];
         }
         temp.left=temp.right=null;
         return temp;
    }   
}


public class ads {
    static int local_depth = 0;
    static Node InsertInKDTree(Node root,int data[],int depth){
        local_depth=depth;
        if(root==null){
            return Node.node_Creation(data);
        }
        
        int currentDepth_temp=depth %3;
        
        if(data[currentDepth_temp ] < root.data[currentDepth_temp] ){
            // go to the left side of the tree:
            root.left=InsertInKDTree(root.left, data, depth+1);
        }
        else{
            // go to the right side of the tree
            root.right=InsertInKDTree(root.right, data, depth+1);
        }
        return root;
    }
    
  
   
    static void inorderOfTree(Node root){
        if(root.left!=null){
            inorderOfTree(root.left);
        }
        System.out.println("("+root.data[0]+","+root.data[1]+","+root.data[2]+")");
        
        if(root.right!=null){
            inorderOfTree(root.right);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter k value");
        //int k=sc.nextInt();
        int data1[]= new int[3];
        int n;
        int ch;
        Node root=null;
        do{
            System.out.println("==========KD TREE==========");
            System.out.println("1.Create tree");
            System.out.println("2.Insert in tree");
            System.out.println("0.Exit");
            System.out.print("Enter Choice : ");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter no. of nodes to be inserted : ");
                    n=sc.nextInt();
                    System.out.println("ENTER VALUES TO INSERT :");
                    for(int i=0;i<n;i++){
                        System.out.print("X_"+i+" : ");
                        data1[0]=sc.nextInt();
                        System.out.print("Y_"+i+" : ");
                        data1[1]=sc.nextInt();
                        System.out.print("Z_"+i+" : ");
                        data1[2]=sc.nextInt();
                        //System.out.print("p_"+i+" : ");
                        //data1[3]=sc.nextInt();
                        root= InsertInKDTree(root, data1, 0);
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("KD TREE :  ");
                    inorderOfTree(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("ENTER VALUE TO INSERT :");
                    System.out.print("X : ");
                    data1[0]=sc.nextInt();
                    System.out.print("Y : ");
                    data1[1]=sc.nextInt();
                    System.out.print("Z : ");
                    data1[2]=sc.nextInt();
                    //System.out.print("p : ");
                    //data1[3]=sc.nextInt();
                    root= InsertInKDTree(root, data1, local_depth);
                    System.out.println();
                    inorderOfTree(root);
                    System.out.println();
                    break;
            }
        }while(ch!=0);
    }
}


/*
===output==========

compile-single:
run-single:
enter k value
==========KD TREE==========
1.Create tree
2.Insert in tree
0.Exit
Enter Choice : 1
Enter no. of nodes to be inserted : 7
ENTER VALUES TO INSERT :
X_0 : 3
Y_0 : 7
Z_0 : 1

X_1 : 2
Y_1 : 6
Z_1 : 4

X_2 : 8
Y_2 : 1
Z_2 : 1

X_3 : 5
Y_3 : 7
Z_3 : 1

X_4 : 6
Y_4 : 6
Z_4 : 2

X_5 : 9
Y_5 : 8
Z_5 : 8

X_6 : 2
Y_6 : 7
Z_6 : 1


KD TREE :  
(2,6,4)
(2,7,1)
(3,7,1)
(8,1,1)
(5,7,1)
(6,6,2)
(9,8,8)

















*/