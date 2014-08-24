import java.util.ArrayList;


public class Demo {
	public static void main(String[] args) {
		System.out.println("New conteiner is created");
		Conteiner<Plant> c = new Conteiner<Plant>();
		Plant plant1=new Flouwer(5,"������",2,"�������");
		Plant plant2=new Flouwer(3,"�������",8,"������");
		Plant plant3=new Flouwer(2,"�������",1,"������");
		Plant plant4=new Tree("�����",2,"������",5);
		Plant plant5=new Tree("���",2,"�����",10);
		Plant plant6=new Tree("��������",2,"���",15);
		System.out.println("Elements was added ==>");
		c.add(plant1);
		c.add(plant2);
		c.add(plant3);
		c.add(plant4);
		c.add(plant5);
		c.add(plant6);
		System.out.println(c);
		System.out.println("==================================================================");
		
		System.out.println("Iterator choose the plants with heigh more than 10 ==>");
		Parser<Plant> parser=new Parser<Plant>(c);
		for (Plant pl : parser) {
			System.out.println(pl);
		}
		System.out.println("==================================================================");
		
		System.out.println("Check if conteiner is empty ==>" + c.isEmpty());
		System.out.println("Size ==>" + c.size());
		System.out.println("==================================================================");
		
		System.out.println("Create new ArrayList c2==>");
		ArrayList<Plant> c2=new ArrayList<Plant>();
		c2.add(new Flouwer(3,"�������",8,"������"));
		c2.add(new Flouwer(2,"�������",1,"������"));
		c2.add(new Tree("�����",2,"������",5));
		System.out.println(c2);
		System.out.println("Check if conteiner conteins all arrailist ==>"+c.containsAll(c2));
		System.out.println("==================================================================");
		
		ArrayList<Plant> c3=new ArrayList<Plant>();
		c3.add(new Flouwer(2,"��������",1,"������"));
		System.out.println("New list c3 ==>"+c3);
		System.out.println("==================================================================");
		
		System.out.println("Insert c3 to the end of container ==>");
		c.addAll(c3);
		System.out.println(c);
		System.out.println("==================================================================");
		
		System.out.println("Insert c3 on 2d position ==>");
		c.addAll(2, c3);
		System.out.println(c);
		System.out.println("==================================================================");
		
		System.out.println("Remove all c3 from c==>"+c.removeAll(c3));
		System.out.println(c);
		System.out.println("==================================================================");
		
		System.out.println("retainAll c2 from c ==>"+c.retainAll(c2));
		System.out.println(c);
		System.out.println("==================================================================");
		
		System.out.println("SubList ==>"+c.subList(0, 3));
		System.out.println("New element added by index ==>");
		c.add(0, new Flouwer(2,"�����������",1,"������"));
		System.out.println(c);
		System.out.println("==================================================================");
		
		System.out.println("Get element buy index ==>"+c.get(2));
		System.out.println(c.set(2,new Flouwer(2,"��������������",1,"������")));
		System.out.println(c);
		
	}

}
