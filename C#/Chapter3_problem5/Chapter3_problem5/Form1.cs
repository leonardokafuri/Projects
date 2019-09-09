using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter3_problem5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            double f = double.Parse(textBox1.Text);
            double c = ((5 / 9.0) * (f + 32));

            textBox2.Text = c.ToString()+" " + "Fahrenheit" ; 
        }

        private void button2_Click(object sender, EventArgs e)
        {
            double f = double.Parse(textBox1.Text);
            double c = (( 5/ 9.0 ) * (f -32));

            textBox2.Text = c.ToString() + " " + "Celsius";
        }
    }
}
