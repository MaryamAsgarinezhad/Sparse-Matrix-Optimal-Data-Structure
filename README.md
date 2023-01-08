# Sparse-Matrix-Optimal-Data-Structure

Definition :
The goal of this project is to write a program to maintain and perform operations on thin matrices.
In a thin matrix, a large number of entries are equal to zero and only a limited number of non-zero entries.
Therefore, to save memory consumption, it is sufficient to keep only the non-zero values . For example, for a 100 x 100 matrix that has only 5 non-zero cells
([1,4]=120, [15,30]=4, [15,33]=18, [80,30]=21, [100,100]= 12) , If we want to use two-dimensional arrays, we have to reserve 10,000 houses in memory,
while we only need to store 5 values. An alternative method to store these types of matrices is to use a linked list. 

Below is a suggested method for The maintenance of the matrix mentioned above is shown:

![image](https://user-images.githubusercontent.com/118456195/211202251-29cc1030-7833-47bb-ad6f-8d525c33c71e.png)

In this exercise, we will write the appropriate data structure to maintain a thin matrix and the necessary algorithms to add and multiply two matrices. The input of your program in two lines contains the specifications of two matrices, in each line, firstly, the number of rows and columns of the matrix, and then the cells of that matrix, where each cell is identified by the row number, column number, and cell value. The third input line is one of the SUM or MUL values ​​to determine the addition or product operation. The output of the program is the resulting matrix in such a way that the order of displaying the cells in the output is based on the row number and then the column number. Input cells are not necessarily ordered in this order. The dimensions of the two input matrices should be considered suitable for the respective operation.

It is not allowed to use the array in this program. Both input and output values ​​are separated by commas and there is no other space between them.

Sample input:

2,2,1,1,5,2,1,7

2,2,2,2,3,1,1,8

SUM

Sample output:
2,2,1,1,13,2,1,7,2,2,3
