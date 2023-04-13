package lab9;

import java.util.ArrayList;
public class Heap<T extends Comparable<T>>{
	private ArrayList<T> heapList;
	public Heap(){
		heapList = new ArrayList<T>();
	}
	public int size(){
		return heapList.size();
	}
	public boolean isEmpty(){
		return (size()==0);
	}
	public void clear(){
		heapList.clear();
	}
	public void enumerate(){
		System.out.println(heapList);
	}

	public void add(T item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);

		while (index > 0 && item.compareTo(parent) > 0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}

	public T findMin(){
		T min = heapList.get(0);

		if (isEmpty()){
			System.out.println("Heap is empty");
			return null;
		}

		else if (heapList.size() == 0) {
			T ret = heapList.get(0);
			return ret;
		}

		for (int i = 0; i <= heapList.size() - 1; i++) {
			if ( (min.compareTo(heapList.get(i)) == 0) || (min.compareTo(heapList.get(i)) > 0)){
				min = heapList.get(i);
			}
		}

		return min;
	}

	public int find (T key1){
		if (heapList.contains(key1)){
			return 1;
		}
		else
			return 0;
	}

	public void replace (T key1, T key2){
		int indexOfKey1 = heapList.indexOf(key1);

		if (isEmpty()){
			System.out.println("Heap is empty");
			return;
		}

		if (find(key1) == 0){
			System.out.println("Key "+ key1 +" not found.");
			return;
		}
		else // if key was found
		{
			if (key2.compareTo(heapList.get(0)) > 0) // Sift-Up algorithm to be used
			{
				T item = key2;
				heapList.set(indexOfKey1, key2);
				int index = heapList.indexOf(key2);
//				parent of node at index (indexOfKey2)
				int pNode = (index - 1)/2;
				T parent = heapList.get(pNode);

				while (index > 0 && key2.compareTo(parent) > 0){
					heapList.set(index, parent);
					heapList.set(pNode, item);

					index = pNode;
					pNode = (index - 1)/2;
					parent = heapList.get(pNode);
				}
			}
			else // Sift-Down algorithm to be used
			{
				T item = key2;
				heapList.set(indexOfKey1, key2);
				int index = heapList.indexOf(key2); //index of Key 2

// 				children of node at index i:
//				(left) 2*i + 1
//				(right) 2*i + 2
				int indexOfLeftChild, indexOfRightChild, maxChildIndex;
				T maxChild;

				boolean found = false;

				indexOfLeftChild = index*2 +1;
				indexOfRightChild = index*2 +2;

				while (!found)
				{
					if (indexOfLeftChild < size() && indexOfRightChild < size()) // Case 1: Node has two children
					{
						if (heapList.get(indexOfLeftChild).compareTo(heapList.get(indexOfRightChild)) > 0)
						{
							maxChild = heapList.get(indexOfLeftChild);
							maxChildIndex = indexOfLeftChild;
						}
						else
						{
							maxChild = heapList.get(indexOfRightChild);
							maxChildIndex = indexOfRightChild;
						}

						if (item.compareTo(maxChild) < 0)
						{
							heapList.set(maxChildIndex, item);
							heapList.set(index, maxChild);
							index = maxChildIndex;
						}
						else
							found = true;
					}

					else if (indexOfLeftChild < size()) // Case2: node has only left child
					{
						if (item.compareTo(heapList.get(indexOfLeftChild)) < 0)
						{
							T temp = heapList.get(indexOfLeftChild);
							heapList.set(indexOfLeftChild, item);
							heapList.set(index, temp);
							index = indexOfLeftChild;
						}
						else
							found = true;
					}

//				Case3: only right child - this case does not occur since it is a complete binary tree

					else // Case4: no children
					{
						found = true;
					}
					indexOfLeftChild = index*2+1;
					indexOfRightChild = index*2+2;
				}
			}
		}
	}

	public T deleteMax(){
		if (isEmpty()){
			System.out.println("Heap is empty");
			return null;
		}
		else {
			T ret = heapList.get(0); //item to be removed is in root
			T item = heapList.remove(heapList.size()-1); //remove the last item

			if (heapList.size()==0) {
				return ret;
			}

			heapList.set(0, item); //set the root with the last item
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found = false;
			index = 0;
			lIndex = index*2 +1;
			rIndex = index*2 +2;

			while (!found)
			{
				//case 1: Node has two children
				if (lIndex < size() && rIndex < size())
				{
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex)) > 0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
				
					if (item.compareTo(maxChild) < 0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else
						found = true;
				}

//				case2: node has only left child
				else if (lIndex < size())
				{
					if (item.compareTo(heapList.get(lIndex)) < 0)
					{
						T temp = heapList.get(lIndex);
						heapList.set(lIndex, item);
						heapList.set(index, temp);
						index = lIndex;
					}
					else	
						found = true;
				}

//				case3: only right child - this case does not occur since it is a complete binary tree

//				case4: no children
				else {
					found = true;
				}

				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}
	} //deleteMax()

}
