using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_4
{
    class Employee
    {
        public string Name { get; set; }
        public int IdNumber { get; set; }
        public string Departmnet { get; set; }
        public string Position { get; set; }
        public Employee()
        {
            Name = "";
            Departmnet = "";
            Position = "";
            IdNumber = 0;
        }
        public Employee(string empName , int id)
        {
            Name = empName;
            IdNumber = id;
            Departmnet = "";
            Position = "";
        }
        
        public Employee(string empName, int id , string dept, string pos)
        {
            Name = empName;
            IdNumber = id;
            Departmnet = dept;
            Position = pos;
        }


    }
}
