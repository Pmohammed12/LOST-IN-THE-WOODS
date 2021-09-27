import java.util.*;

class ForestRoam {

    int[] abs={-1,-1,-1,0,0,1,1,1};
    int[] ordi={-1,0,1,-1,1,-1,0,1};
    //northwest (-1,-1)
    //north (-1,0)
    //NorthEast (-1,1)
    //West (0,-1)
    //East (0,1)
    //SouthWest (1,-1)
    //South (1,0)
    //SouthEast (1,1)

    int count=0,Last_count=1000000;
    int px=0,py=0,cx,cy,way_p,way_c,A,B;
    Random rand=new Random();

    ForestRoam() {}
    ForestRoam(int a,int b) {
        this.cx=b-1;
        this.cy=a-1;
        this.A=a;
        this.B=b;
    }

    String compass(int i) {
        switch(i) {
            case 0 : return "NorthWest";
            case 1 : return "North";
            case 2 : return "NorthEast";
            case 3 : return "West";
            case 4 : return "East";
            case 5 : return "SouthWest";
            case 6 : return "South";
            case 7 : return "SouthEast";
        }
        return null;
    }

    //method to start simulation
    int start_roam() {

        while(count<=Last_count) {

            ++count;
            way_p=rand.nextInt(8);
            way_c=rand.nextInt(8);

            //printing directions
            System.out.println("Pat choose : "+compass(way_p));
            System.out.println("Chris choose : "+compass(way_c));

            //checking whether pat and chris are going out of boundaries
            if((px+abs[way_p]>=0 && px+abs[way_p]<B) && (py+ordi[way_p]>=0 && py+ordi[way_p]<A)) {
                px+=abs[way_p];
                py+=ordi[way_p];
            }

            if((cx+abs[way_c]>=0 && cx+abs[way_c]<B) && (cy+ordi[way_c]>=0 && cy+ordi[way_c]<A)) {
                cx+=abs[way_c];
                cy+=ordi[way_c];
            }

            //printing new coordinates of pat and Chris
            System.out.println("Pat is at ("+px+","+py+")");
            System.out.println("Chrisis at ("+cx+","+cy+")");
            System.out.println();
            Scanner in=new Scanner(System.in);
            in.nextLine();

            if((px==cx) && (py==cy)) break;
        }

        return count;
    }
}

public class Main
{
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int A,B;

        //take input A B
        while(true) {
            System.out.println("enter the dimentions of the grid");
            System.out.println("Enter A such that 2<=A<=50: ");
            A=in.nextInt();
            System.out.println("Enter B such that 2<=B<=50: ");
            B=in.nextInt();

            if((A>=2 && A<=50) && (B>=2 && B<=50)) break;
            else System.out.println("Invalid length");
        }

        //creating simulation object and starting simulation
        ForestRoam ob1=new ForestRoam(A,B);
        int timer=ob1.start_roam();
        if(timer<=1000000) System.out.println("Time required to meet: "+timer);
        else System.out.println("1000000 exceeded");
    }
}