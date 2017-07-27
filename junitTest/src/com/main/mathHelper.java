package com.main;

public class mathHelper {

	public int add(int ...  nums){
		int res=0;
		for(int i:nums)
			res+=i;
		return res;
	}

	public int sub(int a,int b){
		
		return a-b;
	}

	public int mul(int ...  nums){
		int res=1;
		for(int i:nums)
			res=res*i;
		return res;	}

	public int div(int a,int b){
		
		return a/b;
	}

	
}
