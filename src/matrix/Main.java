package matrix;
import java.util.Scanner;

public class Main {

    static row r1 = new row();
    static matrixlist n1 = new matrixlist();
    static row r2 = new row();
    static matrixlist n2 = new matrixlist();
    static row mulrow = new row();
    static matrixlist mulmatrix = new matrixlist(mulrow);
    static String size1 = new String();
    static String size2 = new String();
    static int mulvalue=0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();
        String op = input.next();
        str1 = str1 + ",";
        str2 = str2 + ",";

        int j1 = 0;
        int j2 = 0;
        j1 = str1.indexOf(',', 0);
        String mulsize1=str1.substring(0, j1);
        
        j2 = str1.indexOf(',', j1 + 1);
        size1 = str1.substring(0, j2);
        int u = 0;
        int i = j2 + 1;
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t = 0;
        int s = 0;
        int build = 0;
        while (i != str1.length()) {
            if (build == 0) {
                if (str1.charAt(i) != ',') {
                    t = (t * 10) + str1.charAt(i) - '0';
                    i++;
                } else {
                    if (s == 0) {
                        t1 = t;
                        t = 0;
                        s = 1;
                        i++;
                    } else {
                        if (s == 1) {
                            t2 = t;
                            t = 0;
                            s = 2;
                            i++;
                            if (str1.charAt(i) == '-') {
                                i++;
                                u = 1;
                            }
                        } else {
                            if (s == 2) {
                                if (u == 1) {
                                    t3 = -t;
                                    u = 0;
                                } else {
                                    t3 = t;
                                }
                                t = 0;
                                s = 0;
                                i++;
                                build = 1;
                            }
                        }
                    }
                }
            }
            if (build == 1) {
                if (t3 == 0) {
                    build = 0;
                } else {
                    insertrow1(r1, t1, t2, t3);
                    build = 0;
                }
            }
        }
        j1 = str2.indexOf(',', 0);
        j2 = str2.indexOf(',', j1 + 1);
        String mulsize2=str2.substring(j1,j2);
        String mulsize=mulsize1+mulsize2;
        size2 = str2.substring(0, j2);

        i = j2 + 1;
        u = 0;
        t1 = 0;
        t2 = 0;
        t3 = 0;
        t = 0;
        s = 0;
        build = 0;
        while (i != str2.length()) {
            if (build == 0) {
                if (str2.charAt(i) != ',') {
                    t = (t * 10) + str2.charAt(i) - '0';
                    i++;
                } else {
                    if (s == 0) {
                        t1 = t;
                        t = 0;
                        s = 1;
                        i++;
                    } else {
                        if (s == 1) {
                            t2 = t;
                            t = 0;
                            s = 2;
                            i++;
                            if (str2.charAt(i) == '-') {
                                i++;
                                u = 1;
                            }
                        } else {
                            if (s == 2) {
                                if (u == 1) {
                                    t3 = -t;
                                    u = 0;
                                } else {
                                    t3 = t;
                                }
                                t = 0;
                                s = 0;
                                i++;
                                build = 1;
                            }
                        }
                    }
                }
            }
            if (build == 1) {
                if (t3 == 0) {
                    build = 0;
                } else {
                	if(op.equals("MUL")){
                		insertrow2(r2, t2, t1, t3);
                        build = 0;
                	}
                	else{
                		insertrow2(r2, t1, t2, t3);
                        build = 0;
                	}
                }
            }
        }
        if (op.equals("SUM")) {
            StringBuilder sss = new StringBuilder();
            if (n1.first == null && n2.first == null) {
                sss.append(size2 + ',' + '0');
                System.out.println(size2 + ',' + '0');
            } else {
                if (n2.first == null) {
                    sss.append(size1);
                    System.out.print(size1);
                    row w = n1.first;
                    while (w != null) {
                        column z = w.next;
                        while (z != null) {
                            if ((z.value) != 0) {
                                sss.append(',' + String.valueOf(w.index) + ',' + String.valueOf(z.index) + ',' + String.valueOf(z.value));
                                System.out.print(',' + String.valueOf(w.index) + ',' + String.valueOf(z.index) + ',' + String.valueOf(z.value));

                            }
                            z = z.next;
                        }
                        w = w.lower;
                    }
                }
                if (n1.first == null) {
                    sss.append(size2);
                    System.out.print(size2);
                    row w = n2.first;
                    while (w != null) {
                        column z = w.next;
                        while (z != null) {
                            if ((z.value) != 0) {
                                sss.append(',' + String.valueOf(w.index) + ',' + String.valueOf(z.index) + ',' + String.valueOf(z.value));

                                System.out.print(',' + String.valueOf(w.index) + ',' + String.valueOf(z.index) + ',' + String.valueOf(z.value));
                            }
                            z = z.next;
                        }
                        w = w.lower;
                    }
                }
            }
            if (n1.first != null && n2.first != null) {
                while (n2.first != null) {
                    mergerow(r1, n2.first, n2.first.lower);
                }
                sss.append(size2);
                System.out.print(size2);
                row w = n1.first;
                while (w != null) {
                    column z = w.next;
                    while (z != null) {
                        if ((z.value) != 0) {
                            sss.append(',' + String.valueOf(w.index) + ',' + String.valueOf(z.index) + ',' + String.valueOf(z.value));
                            System.out.print(',' + String.valueOf(w.index) + ',' + String.valueOf(z.index) + ',' + String.valueOf(z.value));
                        }
                        z = z.next;
                    }
                    w = w.lower;
                }
            }
            String ff = sss.toString();
            int count = 0;
            for (int k = 0; k < ff.length(); k++) {
                if (ff.charAt(k) == ',') {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(",0");
            }
        }
        
        if (op.equals("MUL")) {
            StringBuilder sss = new StringBuilder();
            if (n1.first == null || n2.first == null) {
            	 sss.append(mulsize + ',' + '0');
                 System.out.println(mulsize + ',' + '0');
            }    
            else {
            	
            	 row w=n1.first;
            	    sss.append(mulsize);
            	    System.out.print(mulsize);
            	    while(r2!=null){
            	    	   while(w!=null){
            	    		      column z=w.next;
            	    		      while(z!=null){
            	    		    	mulvalue=0;
            	    		        column g=r2.next;
            	    		        while(g!=null){
            	    		        	if(z.index==g.index){
            	    		        		mulvalue=mulvalue+(g.value+z.value);
            	    		        		g=g.next;
            	    		        	}
            	    		        }
            	    		        z=z.next;
            	    		        if(mulvalue!=0){
            	    		        	sss.append(',' + String.valueOf(w.index) + ',' + String.valueOf(r1.index) + ',' + String.valueOf(mulvalue));
            	                        System.out.print(',' + String.valueOf(w.index) + ',' + String.valueOf(r1.index) + ',' + String.valueOf(mulvalue));    		        }
            	    		      }
            	    		      w=w.lower;
            	    		    }
            	    	   r2=r2.lower;
            	    }
            }
            String ff = sss.toString();
            int count = 0;
            for (int k = 0; k < ff.length(); k++) {
                if (ff.charAt(k) == ',') {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(",0");
            }
        }
   
    }
    public static void insertcolumn1(row a, column c, int s2, int s3) {
        if (s2 > c.index) {
            if (c.next == null) {
                column cnext = new column(s2, s3, null);
                c.insertafter(cnext);
            } else {
                if (s2 < c.next.index) {
                    column cnext = new column(s2, s3, c.next);
                    c.next = cnext;
                } else {
                    insertcolumn1(a, c.next, s2, s3);
                }
            }
        }
        if (s2 < c.index) {
            column cnext = new column(s2, s3, c);
            a.next = cnext;
        }
    }

    public static void insertrow1(row a, int o1, int o2, int o3) {
        if (a.next == null) {
            column c = new column(o2, o3, null);
            row k = new row(o1, null, c);
            r1 = k;
            n1.first = r1;
        } else {
            if (a.index > o1) {
                column c = new column(o2, o3, null);
                row k = new row(o1, r1, c);
                n1.first = k;
                r1 = k;
            }
            if (a.index < o1) {
                if (a.lower == null) {
                    column c = new column(o2, o3, null);
                    row k = new row(o1, null, c);
                    a.lower = k;
                } else {
                    if (a.lower.index > o1) {
                        column c = new column(o2, o3, null);
                        row k = new row(o1, a.lower, c);
                        a.lower = k;
                    } else {
                        insertrow1(a.lower, o1, o2, o3);
                    }
                }
            }
            if (a.index == o1) {
                insertcolumn1(a, a.next, o2, o3);
            }
        }
    }

    public static void insertcolumn2(row a, column c, int s2, int s3) {
        if (s2 > c.index) {
            if (c.next == null) {
                column cnext = new column(s2, s3, null);
                c.insertafter(cnext);
            } else {
                if (s2 < c.next.index) {
                    column cnext = new column(s2, s3, c.next);
                    c.next = cnext;
                } else {
                    insertcolumn2(a, c.next, s2, s3);
                }
            }
        }
        if (s2 < c.index) {
            column cnext = new column(s2, s3, c);
            a.next = cnext;
        }
    }

    public static void insertrow2(row a, int s1, int s2, int s3) {
        if (a.next == null) {
            column c = new column(s2, s3, null);
            row k = new row(s1, null, c);
            r2 = k;
            n2.first = r2;
        } else {
            if (a.index > s1) {
                column c = new column(s2, s3, null);
                row k = new row(s1, r2, c);
                n2.first = k;
                r2 = k;
            }
            if (a.index < s1) {
                if (a.lower == null) {
                    column c = new column(s2, s3, null);
                    row k = new row(s1, null, c);
                    a.lower = k;
                } else {
                    if (a.lower.index > s1) {
                        column c = new column(s2, s3, null);
                        row k = new row(s1, a.lower, c);
                        a.lower = k;
                    } else {
                        insertrow2(a.lower, s1, s2, s3);
                    }
                }
            }
            if (a.index == s1) {
                insertcolumn2(a, a.next, s2, s3);
            }
        }
    }

    public static void columnmerge(row a, column c, column cnext, column nc) {
        if (cnext.index > c.index) {
            if (c.next == null) {
                cnext.next = null;
                c.insertafter(cnext);
                n2.first.next = nc;
            } else {
                if (cnext.index < c.next.index) {
                    cnext.next = c.next;
                    c.next = cnext;
                    n2.first.next = nc;
                } else {
                    columnmerge(a, c.next, cnext, nc);
                }
            }
        }
        if (cnext.index < c.index) {
            cnext.next = c;
            a.next = cnext;
            n2.first.next = nc;
        }
        if (cnext.index == c.index) {
            c.value = c.value + cnext.value;
            n2.first.next = nc;
        }
    }

    public static void mergerow(row a, row k, row lk) {
        if (a.index > k.index) {
            n2.first.lower = r1;
            n1.first = n2.first;
            r1 = n1.first;
            n2.first = lk;
        }
        if (a.index < k.index) {
            if (a.lower == null) {
                n2.first.lower = null;
                a.lower = k;
                //r1=n2.first;
                n2.first = lk;
            } else {
                if (a.lower.index > k.index) {
                    n2.first.lower = a.lower;
                    a.lower = k;
                    //r1=n2.first;
                    n2.first = lk;
                } else {
                    mergerow(a.lower, k, lk);
                }
            }
        }
        if (a.index == k.index) {
            while (n2.first.next != null) {
                columnmerge(a, a.next, n2.first.next, n2.first.next.next);
            }
            //r1=n2.first;
            n2.first = lk;
        }
    }
		
}

class row {
    public int index;
    public row lower;
    public column next;

    public row() {

    }

    public row(int i, row lower, column next) {
        this.index = i;
        this.next = next;
        this.lower = lower;
    }

    public row(int i, column next) {
        this.index = i;
        this.next = next;
    }

    public void insertafter(row b) {
        b.lower = this.lower;
        this.lower = b;
    }


}

class column {
    public int index;
    public int value;
    public column next;

    public column() {

    }

    public column(int index, int value, column next) {
        this.index = index;
        this.value = value;
        this.next = next;
    }


    public void insertafter(column n) {
        n.next = this.next;
        this.next = n;
    }

}

class matrixlist {
    public row first;

    public matrixlist() {

    }

    public matrixlist(row n) {
        this.first = n;
    }

}

