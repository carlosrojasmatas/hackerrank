 static long triplets(int[] a, int[] b, int[] c) {

 	long counter =0 ;
 	for(int i=0; i < a.lenght; i++){
 		for (int j=0; j < b.length;j++){
 			for (int k=0;k < c.length; j++){
 				if(a[i] < b[j] < c[k]){
 					counter = counter + 1;
 				}
 			}
 		}
 	}

 	return counter;
 }