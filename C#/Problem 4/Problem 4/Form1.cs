using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Problem_4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        List<Employee> mylist;
        private void Form1_Load(object sender, EventArgs e)
        {
            Employee e1 = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
            Employee e2 = new Employee("Mark Jones", 39119, "IT", "Programmer");
            Employee e3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");

            mylist = new List<Employee>();
            mylist.Add(e1);
            mylist.Add(e2);
            mylist.Add(e3);
        }

       

        private void button1_Click_1(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;//remove previous values
            dataGridView1.DataSource = mylist;
        }
    }
}
