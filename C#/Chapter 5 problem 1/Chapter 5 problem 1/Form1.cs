using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter_5_problem_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            richTextBox1.Text = "";
            int n;
            int s;
            s = int.Parse(textBox1.Text);  //speed
            n = int.Parse(textBox2.Text);  //hours
            for (int a =1; a<= n ; a++) 
            {
                richTextBox1.AppendText("After Hour "  + a + ". The distance is " + (a * s) + "\n");
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();

        }
    }
}
