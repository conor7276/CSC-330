using system;
namespace OurFirstCSharpApp{
    internal class Program
    {
        static void main(){
            Console.wirteLine("Hello, WOrld!");
            Console.write("Blah");
            
            //Everything in C# is an object.
            // There are no primitive data types.
            int num1;
            num1 = 10;
            Console.WriteLine(num1);

            // Math works the same.

            int[] myArr = {1,2,3,4,5};
            int[,] grid = new int[4,5];

            Console.Write(grid);
            foreach(int row in grid)
            {
                foreach(int i in row){
                    Console.write(i + " ");

                }
                Console.WriteLine();
            }
            
        }
    }
}