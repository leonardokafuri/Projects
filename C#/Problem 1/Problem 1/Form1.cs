using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Problem_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string str = textBox1.Text;
            int n;
            n=countMe(str);
            label2.Text = "There are " + n + " words ";
        }

        private int countMe (string x)
        {
            int numOfwords = 0;
            string[] t = x.Split(); // default is space 
            numOfwords = t.Length;

            return numOfwords;
        }

    }
}
