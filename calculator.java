package GUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
public class calculator extends JFrame implements ActionListener
{
	private JTextField tf = new JTextField("0",15);
	private JButton b0 = new JButton("0");
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton	add= new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mul = new JButton("*");
	private JButton	div = new JButton("/");
	private JButton	eql = new JButton("=");
	private JButton	start = new JButton("C");
	private JPanel p = new JPanel();
	private Container c = getContentPane();
	private JPanel p2 = new JPanel();
	double result = 0;
	int r = 0;
	int re = 0;
	int i = 0;
	int a = 0;
	double num1,num2;
	ArrayList<String> numbers = new ArrayList<>();
	ArrayList<String> operators = new ArrayList<>();
	public calculator()
	
	{
		super("Calculator");
		setSize(400,400);
		setLocationRelativeTo(null);
		p.add(tf);
		p2.setLayout(new GridLayout(4,4));
	
		
		p2.add(b0);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(add);
		p2.add(sub);
		p2.add(mul);
		p2.add(div);
		p2.add(eql);
		p2.add(start);
		c.add(p,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		
		setVisible(true);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		eql.addActionListener(this);
		start.addActionListener(this);
		
		Mouse m = new Mouse();
		b0.addMouseListener(m);
		
		
	}
	private class Mouse implements MouseListener
	{
		public void mouseEntered(MouseEvent ae)
		{
			Object obj = ae.getSource();
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
			
			if(ae.getSource() == b0 || ae.getSource() == b1 || ae.getSource() == b2 || ae.getSource() == b3 || ae.getSource() == b4
			|| ae.getSource() == b5 || ae.getSource() == b6 || ae.getSource() == b7 || ae.getSource() == b8 || ae.getSource() == b9)
			{
				
				String s  = ae.getActionCommand();
				
				String v = tf.getText();
		
				if(v.equals("0"))
				{
					tf.setText(s);
					
				}
				else if(v.equals(String.valueOf(result)))
				{
					tf.setText(s);
				}
				
				
				else
				{
					tf.setText(tf.getText()+s);
					
				}
				
			
				
			}
			if(ae.getSource() == add || ae.getSource() == sub || ae.getSource() == mul || ae.getSource() == div)
			{
				
				if(tf.getText().equals("0"))
				{
					tf.setText("0");
				}
				
				else
				{
					numbers.add(tf.getText());
					operators.add(ae.getActionCommand());
					
					
					if(operators.size() >= 2 && re  == 0)
					{
						
						
							if(r == 0)
							{
					
								
								if(operators.get(0).equals("+"))
								{
									num1 = Double.parseDouble(numbers.get(0));
									num2 = Double.parseDouble(numbers.get(1));
									result = num1 + num2;
									tf.setText(String.valueOf(result));
									
								}
								else if(operators.get(0).equals("-"))
								{
									num1 = Double.parseDouble(numbers.get(0));
									num2 = Double.parseDouble(numbers.get(1));
									result = num1 - num2;
									tf.setText(String.valueOf(result));
									
								}
								else if(operators.get(0).equals("*"))
								{
									num1 = Double.parseDouble(numbers.get(0));
									num2 = Double.parseDouble(numbers.get(1));
									result = num1 * num2;
									tf.setText(String.valueOf(result));
							
								}	
								else if(operators.get(0).equals("/"))
								{
									num1 = Double.parseDouble(numbers.get(0));
									num2 =Double.parseDouble(numbers.get(1));
									result = num1 / num2;
									tf.setText(String.valueOf(result));
									
								}
							r++;
							
							
							}
						
							else 
							{
							
								if(operators.get(operators.size()-2).equals("+"))
								{
								
									result = result + Double.parseDouble(numbers.get(numbers.size()-1));
									tf.setText(String.valueOf(result));
									r++;
								}
								else if(operators.get(operators.size()-2).equals("-"))
								{
									result = result - Double.parseDouble(numbers.get(numbers.size()-1));
									tf.setText(String.valueOf(result));
									r++;
								}
								else if(operators.get(operators.size()-2).equals("*"))
								{
									result = result * Double.parseDouble(numbers.get(numbers.size()-1));
									tf.setText(String.valueOf(result));
									r++;
								}
								else if(operators.get(operators.size()-2).equals("/"))
								{
									
									result = result / Double.parseDouble(numbers.get(numbers.size()-1));
									tf.setText(String.valueOf(result));
									r++;
								}
							
							}
					}
					
					else if(re > 0 && operators.size() >=2)
					{
						if(tf.getText().equals(String.valueOf(result)))
						{
							tf.setText("0");
						}
						else
						{
							if(operators.get(operators.size()-2).equals("+"))
							{
							
								result = result + Double.parseDouble(numbers.get(numbers.size()-1));
								tf.setText(String.valueOf(result));
								r++;
							}
							else if(operators.get(operators.size()-2).equals("-"))
							{
								result = result - Double.parseDouble(numbers.get(numbers.size()-1));
								tf.setText(String.valueOf(result));
								r++;
							}
							else if(operators.get(operators.size()-2).equals("*"))
							{
								result = result * Double.parseDouble(numbers.get(numbers.size()-1));
								tf.setText(String.valueOf(result));
								r++;
							}
							else if(operators.get(operators.size()-2).equals("/"))
							{
								
								result = result / Double.parseDouble(numbers.get(numbers.size()-1));
								tf.setText(String.valueOf(result));
								r++;
							}
						
						}
					}
					else
					{
						tf.setText("0");
					}
					
					
				}
				
			}
			
			if(ae.getSource() == eql)
			{
				if(numbers.size() == 0 && operators.size() == 0)
				{
					tf.setText("0");
				}
				else
				{
					
				
				numbers.add(tf.getText());
				if(r == 0)
				{
					if(operators.get(operators.size()-1).equals("+"))
				{
					num1 = Double.parseDouble(numbers.get(0));
					num2 = Double.parseDouble(numbers.get(1));
					result = num1 + num2;
					tf.setText(String.valueOf(result));
					
					
				}
				else if(operators.get(operators.size()-1).equals("-"))
				{
					num1 = Double.parseDouble(numbers.get(0));
					num2 =Double.parseDouble(numbers.get(1));
					result = num1 - num2;
					tf.setText(String.valueOf(result));
					
				}
				else if(operators.get(operators.size()-1).equals("*"))
				{
					num1 =Double.parseDouble(numbers.get(0));
					num2 = Double.parseDouble(numbers.get(1));
					result = num1 * num2;
					tf.setText(String.valueOf(result));
			
				}	
				else if(operators.get(operators.size()-1).equals("/"))
				{
					num1 = Double.parseDouble(numbers.get(0));
					num2 = Double.parseDouble(numbers.get(1));
					result = num1 / num2;
					tf.setText(String.valueOf(result));
					
				}
					r++;
					re++;
				}
				else
				{
				
					if(operators.get(operators.size()-1).equals("+"))
					{
					
						result = result + Double.parseDouble(numbers.get(numbers.size()-1));
						tf.setText(String.valueOf(result));
						r++;
					
					}
					else if(operators.get(operators.size()-1).equals("-"))
					{
						result = result - Double.parseDouble(numbers.get(numbers.size()-1));
						tf.setText(String.valueOf(result));
						r++;
						
					}
					else if(operators.get(operators.size()-1).equals("*"))
					{
						result = result * Double.parseDouble(numbers.get(numbers.size()-1));
						tf.setText(String.valueOf(result));
						r++;
						
					}
					else if(operators.get(operators.size()-1).equals("/"))
					{
						
						result = result / Double.parseDouble(numbers.get(numbers.size()-1));
						tf.setText(String.valueOf(result));
						r++;
					
					}
				
				}
			}	
				
			}
			if(ae.getSource() == start)
			{
				tf.setText("0");
				numbers.removeAll(numbers);
				operators.removeAll(operators);
				r = 0;
				re = 0 ;
			}
		
		
	}
	
	public static void main(String[] args) 
	{
		
		new calculator();
	}



}
