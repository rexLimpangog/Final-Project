
package FinalProjectDS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Studlist<T> implements Iterable<T>{

	private final List<T> Studlist = new ArrayList<>();
        
        private int Size=0;
        private T [] data;
        public Studlist() { emptyArray();}
        public void clear(){ emptyArray(); }
        private void emptyArray()
        {
        Size=0;
        ensureCapacity(100);
        }
	public int size() {return Size;}  
        public boolean isEmpty() { return size()==0;}
        public T get(int val) {
            if( val < 0 || val >= size())
                throw new ArrayIndexOutOfBoundsException();
		return data[val];
        }
        
        public T set (int x, T val){
        if( x < 0 || x >= size())
        throw new ArrayIndexOutOfBoundsException();
        T old = data[x];
        data[x] = val;       
        return old;
        }
        public void ensureCapacity (int newSize){
        if (newSize < Size)
            return;
        T [] old = data;
        data = (T[]) new Object[newSize];
        for (int i=0; i<size(); i++) data[i]=old[i];
        }
        
        public void add(T val) {
		addTo(size(),val);
        }
        public void addTo (int x, T val){
        if(data.length == size()) ensureCapacity(size()*2+1);
        for (int i = Size; i> x; i--) data[i] = data [i-1];
        data[x]=val;
        Size++;
        }
        
        public void remove(int idx){
        for (int i=idx; i<size()-1; i++) data[i]=data[i+1];
        Size--;
        }
        
        public int indexOf(String search) {
        for (int i = 0; i < data.length; i++) {
        if (data[i].equals(search)) {
            return i;}}       
        return -1;
        }        
        
        public void display(int displayIt){        
        System.out.println(data[displayIt]);
        }
        
	@Override
	public Iterator<T> iterator() {
		return new CustomIterator<>(Studlist);
	}
	
	public class CustomIterator<arr> implements Iterator<arr> {
		// set index determine if reached the end of the collection
		int indexPosition = 0;
		List<arr> internalList;
		// iterate through the collection as a List
		public CustomIterator(List<arr> internalList) {
			this.internalList = internalList;
		}

		@Override
                //check against indexPosition +1
                // if reached the end of the collection
		public boolean hasNext() {
			if(internalList.size() >= indexPosition + 1) {
				return true;
			}
			return false;
		}

		@Override
               
		public arr next() {
			arr val = internalList.get(indexPosition);
			indexPosition += 2;//skip every second element in the collection
			return val;
                        
		}
		
	}
        
        
   public static void main(String args[]) {
       Studlist userID = new Studlist(); //int
       Studlist username = new Studlist();
       Studlist course = new Studlist();
       Studlist campus = new Studlist();
       Studlist status = new Studlist();
       Studlist Vcstatus = new Studlist();
       Studlist Statistics = new Studlist();
       //create  5 array           
        Scanner input = new Scanner(System.in);
       
        
        char signIn,admin; 
       
       System.out.println("WELCOME TO SCHOOL HEALTH AND SAFETY PROGRAM");
       System.out.println("");
       System.out.println("The program use to gather survey of students willing "
                      + "\nto join limited face to face classes at USeP. ");
        System.out.println("\n");
        
       do{
           
           System.out.println("HOME\n");
           System.out.println("[1] Login");
           System.out.println("[2] EXIT\n");          
           System.out.print("SELECT[1-2]:");          
           signIn = input.next().charAt(0);
           
           switch(signIn){
              
               case '1':                        
                             System.out.println("\n[LOG IN]");
                             System.out.print("  Username: ");          
                             String userName = input.next();
                             System.out.print("  Password: ");          
                             String pass = input.next(); 
                             
                    if(userName.equals("admin_CIC") && pass.equals("CIC_admin")){
                             System.out.println("\n_____________________________________________");
                             System.out.println("\n[ ADMIN ]");                                
                           do{
                                System.out.println("--------------------------------------------");
                                System.out.println("    TOOLS:");
                                System.out.println("      [1] DISPLAY ALL DATA"); 
                                System.out.println("      [2] SEARCH USER ");                     
                                System.out.println("      [3] ADD DATA  ");
                                System.out.println("      [4] DELETE DATA ");
                                System.out.println("      [5] UPDATE    ");
                                System.out.println("      [6] SIGN OUT  ");                            
                                System.out.print("    SELECT[1-6]: ");                                
                                                admin = input.next().charAt(0);
                               
                                 
                                switch(admin){
                                     case'1':
                                         System.out.println("\n[ADMIN] DISPLAY DATA");
                                         
                                            if(userID.isEmpty()==true){
                                                System.out.println("-----EMPTY DATABASE----");
                                                System.out.println("add data on database to display");        
                                                }
                                            else if(userID.isEmpty()==false){
                                            
                                            for(int i = 0; i<status.size();i++){ 
                                                if(status.get(i).equals("Positive")){
                                                  Statistics.add(status.get(i));
                                                }}int positive=Statistics.size();
                                                System.out.println("Frequency of Positive Students: "+ positive);
                                                Statistics.clear();
                                            for(int i = 0; i<status.size();i++){ 
                                                if(status.get(i).equals("Quarantined")){
                                                  Statistics.add(status.get(i));
                                                }}int quarantine=Statistics.size();
                                                System.out.println("Frequency of Quarantined Students: "+ quarantine);
                                                Statistics.clear();
                                            for(int i = 0; i<Vcstatus.size();i++){ 
                                                if(Vcstatus.get(i).equals("Not")){
                                                  Statistics.add(Vcstatus.get(i));
                                                }}int not=Statistics.size();
                                                System.out.println("Frequency of Not yet Vaccinated Students: "+ not);
                                                Statistics.clear();
                                             for(int i = 0; i<Vcstatus.size();i++){ 
                                                if(Vcstatus.get(i).equals("Vaccinated")){
                                                  Statistics.add(Vcstatus.get(i));
                                                }}int VAC=Statistics.size();
                                                System.out.println("Frequency of Vaccinated Students: "+ VAC);
                                                Statistics.clear();
                                            for(int i = 0; i<Vcstatus.size();i++){ 
                                                if(Vcstatus.get(i).equals("Fully Vaccinated")){
                                                  Statistics.add(Vcstatus.get(i));
                                                }}int fVAC=Statistics.size();
                                                System.out.println("Frequency of Fully Vaccinated Students: "+ fVAC);
                                                Statistics.clear();
                                                
                                            }        
                                            
                                         break;
                                     case'2':
                                         System.out.println("\n[ADMIN] SEARCH USER");
                                         System.out.print("Search[USeP ID]: ");
                                         String search=input.next();
                                         int index=userID.indexOf(search);
                                         System.out.print("");
                                           userID.display(index);
                                           username.display(index);
                                           course.display(index);
                                           campus.display(index);
                                           status.display(index);
                                           Vcstatus.display(index);
                                         break;
                                     case'3':
                                         char addMore;
                                         do{
                                             System.out.println("\n[ADMIN] ADD DATA");
                                             System.out.println("\nAdd More Data[1]\nExit[2]");
                                             addMore =input.next().charAt(0);
                                         switch(addMore){
                                             case '1':    

                                         System.out.print("USeP ID: ");
                                            String iD = input.next();
                                            userID.add(iD);
                                            
                                         System.out.print("Username[Surname,FI,MI]: "); 
                                            String Name = input.next();
                                            username.add(Name);
                                            
                                         System.out.print("Course: ");
                                            String type = input.next();
                                            course.add(type);
                                            
                                         System.out.print("Campus:  0brero[1], mintal[2] or tagum[3]    "); 
                                            int campuses = input.nextInt();
                                                        if(campuses==1){
                                                        campus.add("Obrero");}
                                                        if(campuses==2){
                                                        campus.add("Mintal");}
                                                        if(campuses==3){
                                                        campus.add("Tagum");}                                          
                                            
                                         System.out.println("Health Status:    Positive[1], Quarantined[2] or Healthy[3]    "); 
                                            int stats = input.nextInt();                                            
                                            if(stats==1){
                                            status.add("Positive"); System.out.println("Status: Positive");}
                                            if(stats==2){
                                            status.add("Quarantined"); System.out.println("Status: Quarantined");}
                                            if(stats==3){
                                            status.add("Healthy"); System.out.println("Status: Healthy");}
                                            
                                         System.out.println("Vaccination Status[Not(1), Yes(2) or Fully Vaccinated(3)]:");
                                         int vac = input.nextInt();                                            
                                            if(vac==1){
                                            Vcstatus .add("Not");System.out.println("Status: Not Vaccinated");}
                                            if(vac==2){
                                            Vcstatus .add("Vaccinated");System.out.println("Status: Vaccinated");}
                                            if(vac==3){
                                            Vcstatus .add("Fully Vaccinated");System.out.println("Status: Fully Vaccinated");}
                                            System.out.println(iD+" added to the Database");
                                         break;
                                         //manipulate data sort
                                }
                                         }while(addMore!='2');
                                         break;

                                     case'4':
                                         System.out.println("\n[ADMIN] DELETE DATA");
                                         System.out.print("Search[USeP ID]: ");
                                         String seDel=input.next();
                                         int deleted=userID.indexOf(seDel);
                                         int del=deleted;
                                         userID.remove(del);
                                            username.remove(del);
                                           course.remove(del);
                                           campus.remove(del);
                                           status.remove(del);
                                           Vcstatus.remove(del);
                                         
                                         break;
                                     case'5':
                                         System.out.println("\n[ADMIN] UPDATE");
                                         System.out.print("Search[USeP ID]: ");
                                         String update=input.next();
                                         int indx=userID.indexOf(update);
                                         int element=indx;
                                         
                                         System.out.println("[Update]");
                                         System.out.println("Name[1]\nCourse[2]\nCampus[3]\nHealth Status\n[4]Vaccination Status[5]\nAll[6]\n");
                                         char decs =input.next().charAt(0);
                                                        if(decs=='1'){
                                                        System.out.print("New Name:");
                                                        String newName=input.next();
                                                        username.set(element,newName);
                                                        }
                                                        if(decs=='2'){
                                                        System.out.print("Change Course:");
                                                        String cor=input.next();
                                                        course .set(element,cor);
                                                        }
                                                        if(decs=='3'){
                                                        System.out.print("Transfer Campus: obrero[1], mintal[2] or tagum[3]");
                                                        int newcamp=input.nextInt();
                                                                                                    
                                                        if(newcamp==1){
                                                        campus.set(element,"Obrero");}
                                                        if(newcamp==2){
                                                        campus.set(element,"Mintal");}
                                                        if(newcamp==3){
                                                        campus.set(element,"Tagum");}
                                                        }
                                                        if(decs=='4'){
                                                        System.out.println("Health Status Updates: Positive[1], Quarantined[2] or Healthy[3]");
                                                        int upH = input.nextInt();                                            
                                                        if(upH==1){
                                                        status.set(element,"Positive");}
                                                        if(upH==2){
                                                        status.set(element,"Quarantined");}
                                                        if(upH==3){
                                                        status.set(element,"Healthy");}
                                                        }
                                                        if(decs=='5'){
                                                        System.out.print("Vaccination Status Updates:");
                                                         System.out.println("Vaccination Status[Not(1), Yes(2) or Fully Vaccinated(3)]:");
                                                        int Upvac = input.nextInt();                                            
                                                         if(Upvac==1){
                                                         Vcstatus .set(element,"Not");}
                                                         if(Upvac==2){
                                                         Vcstatus .set(element,"Vaccinated");}
                                                         if(Upvac==3){
                                                         Vcstatus .set(element,"Fully Vaccinated");}
                                                         }
                                                        if(decs=='6'){
                                                        System.out.print("New Name:");
                                                        String newNme=input.next();
                                                        username.set(element,newNme);
                                                        System.out.print("Change Course:");
                                                        String cors=input.next();
                                                        course .set(element,cors);
                                                        System.out.print("Transfer Campus:");
                                                        String newcam=input.next();
                                                        campus .set(element,newcam);
                                                        System.out.println("Health Status Updates: Positive[1], Quarantined[2] or Healthy[3]");
                                                        int HlthUP = input.nextInt();                                            
                                                        if(HlthUP==1){
                                                        status.set(element,"Positive");}
                                                        if(HlthUP==2){
                                                        status.set(element,"Quarantined");}
                                                        if(HlthUP==3){
                                                        status.set(element,"Healthy");}
                                                        System.out.print("Vaccination Status Updates:");
                                                         System.out.println("Vaccination Status[Not(1), Yes(2) or Fully Vaccinated(3)]:");
                                                        int vacUP = input.nextInt();                                            
                                                         if(vacUP==1){
                                                         Vcstatus .set(element,"Not");}
                                                         if(vacUP==2){
                                                         Vcstatus .set(element,"Vaccinated");}
                                                         if(vacUP==3){
                                                         Vcstatus .set(element,"Fully Vaccinated");}
                                                            }
                                         
                                }  
                            }                           
                            while(admin!='6');
                            System.out.println("_____________________________________________");
                            }
                        else if(userName.equals("admin_CIC") ==false && pass.equals("CIC_admin")==false){
                        System.out.println("WRONG USERNAME AND PASSWORD");
                        }
                   break;
             
           }       
       }
       while (signIn != '2');
        }
    }
        
        
        

