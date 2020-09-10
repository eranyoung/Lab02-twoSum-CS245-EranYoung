import java.util.Scanner;

//Lab2 - twoSum
//written by Eran Young

public class twoSum{


	public twoSum(){};

	public int [] twoSum(int [] list, int sum){
		
		int [] origList=listCopy(list);//copies list so we can find map found indices to original indices
		int [] sortedList=sort(list);//sorts given list least to greatest
		int beg=0,end=list.length-1;
		boolean found=false;
		while(!found){
			if(beg==end){//cannot have same number twice
				break;
			}
			else if(sortedList[beg]+sortedList[end]>sum){//we increment index at end to next smaller value
				end--;
			}
			else if(sortedList[beg]+sortedList[end]<sum){//increment indext at beginning to next larger value
				beg++;
			}
			else//sum is found
				found=true;
		}

		if(found){//Since we sorted the list the indices where we found the sum are not the same as original list
			for(int i=0;i<list.length;i++){//finds values in the original list before returning
				if(sortedList[beg]==origList[i])
					beg=i;
				if(sortedList[end]==origList[i])
					end=i;
			}
			return new int []{beg,end};
		}
		else
			return new int []{-1,-1};
	}

	public int [] sort(int [] list){//sort given list from least to greatest 
		int smallest=list[0];
		for(int i =0;i<list.length;i++){
			if(list[1]<smallest){
				list[0]=list[1];
				list[1]=smallest;
				smallest=list[0];
			}
		}
		return list;
	}
	
	public int [] listCopy(int [] list){//copies given list
		int [] copy=new int [list.length];
		for(int i=0;i<list.length;i++){
			copy[i]=list[i];
		}
		return copy;
	}



	public static void main(String [] args){
		twoSum t=new twoSum();


		Scanner scanner=new Scanner(System.in);

		System.out.println("Enter length for list: ");
		int length=scanner.nextInt();

		int [] list=new int[length];

		System.out.println("Enter values in list: ");
		int i=0;
		while(i<length){
			list[i]=scanner.nextInt();
			i++;
		}

		System.out.println("Enter sum value: ");
		int val=scanner.nextInt();

		int [] index=t.twoSum(list,val);
		System.out.println("Indices: "+index[0]+","+index[1]);

	}
}