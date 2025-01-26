import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Браузер игр");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu vidmenu = new JMenu("Цвет страницы");
        JMenuItem black_vid = new JMenuItem("Черная страница");
        JMenuItem white_vid = new JMenuItem("белая страница");
        JMenuItem pink_vid = new JMenuItem("розовая страница");
        JMenuItem yellow_vid = new JMenuItem("желтая страница");
        JMenuItem standart_vid = new JMenuItem("стандартная страница");

        black_vid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().setBackground(Color.BLACK);
            }
        });

        white_vid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.white);
            }
        });

        pink_vid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.pink);
            }
        });

        yellow_vid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.yellow);
            }
        });

        standart_vid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.white);
            }
        });

        vidmenu.add(black_vid);
        vidmenu.add(white_vid);
        vidmenu.add(pink_vid);
        vidmenu.add(yellow_vid);
        vidmenu.add(standart_vid);
        menuBar.add(vidmenu);


        JMenu options = new JMenu("Настройки");
        JMenuItem exit_options = new JMenuItem("Выход из приложения");
        JMenuItem vesekran_options = new JMenuItem("На весь экран");
        JMenuItem help_options = new JMenuItem("Написать в поддержку");

        exit_options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vesekran_options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setUndecorated(true);
            }
        });

        help_options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Поддержка");
                jFrame.setVisible(true);
                jFrame.setSize(new Dimension(400,400));
                jFrame.setLocationRelativeTo(null);
                JLabel label = new JLabel("");
                label.setText("Поддержки нет");
                label.setFont(new Font("Ariel", Font.BOLD, 50));
                jFrame.getContentPane().add(label);
            }
        });

        options.add(exit_options);
        options.add(vesekran_options);
        options.add(help_options);
        menuBar.add(options);

        frame.setJMenuBar(menuBar);

        JButton register_button = new JButton("Регистрация");
        frame.getContentPane().add(register_button);
        register_button.setBounds(330,0,150,15);

        register_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reg = new JFrame("Регистрация");
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setSize(new Dimension(500,500));
                reg.setLocationRelativeTo(null);
                reg.setLayout(null);
                reg.setVisible(true);
                frame.setVisible(false);

                JTextArea login = new JTextArea("");
                JTextArea password = new JTextArea("");
                reg.getContentPane().add(login);
                reg.getContentPane().add(password);
                login.setBounds(130,150,200,15);
                password.setBounds(130,170,200,15);

                JLabel label = new JLabel("Регистрация");
                reg.getContentPane().add(label);
                label.setFont(new Font("Ariel", Font.BOLD, 29));
                label.setBounds(130,120,200,25);

                JLabel label1 = new JLabel("Логин");
                reg.getContentPane().add(label1);
                label1.setBounds(90,145,200,25);

                JLabel label2 = new JLabel("Пароль");
                reg.getContentPane().add(label2);
                label2.setBounds(80,165,200,25);

                JButton confirm_button = new JButton("Подтвердить");
                reg.getContentPane().add(confirm_button);
                confirm_button.setBounds(130,190,200,20);

                confirm_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try (FileWriter writer = new FileWriter("notes3.txt", false)) {
                            String Login = login.getText();
                            String Password = password.getText();
                            writer.write("Логин " + Login);
                            writer.append("\n");
                            writer.append("Пароль " + Password);
                            writer.flush();
                        } catch (IOException ex) {
                            System.out.println("anlack");
                        }
                    }
                });

                JButton exit = new JButton("Обратно в меню");
                reg.getContentPane().add(exit);
                exit.setBounds(150,230,150,15);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reg.setVisible(false);
                        frame.setVisible(true);
                    }
                });
            }
        });

        JButton vxod_button = new JButton("Вход");
        frame.getContentPane().add(vxod_button);
        vxod_button.setBounds(330,17,150,15);

        vxod_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reg = new JFrame("Вход");
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setSize(new Dimension(500,500));
                reg.setLocationRelativeTo(null);
                reg.setLayout(null);
                reg.setVisible(true);
                frame.setVisible(false);

                JTextArea login1 = new JTextArea("");
                JTextArea password1 = new JTextArea("");
                reg.getContentPane().add(login1);
                reg.getContentPane().add(password1);
                login1.setBounds(130,150,200,15);
                password1.setBounds(130,170,200,15);

                JLabel label = new JLabel("Вход");
                reg.getContentPane().add(label);
                label.setFont(new Font("Ariel", Font.BOLD, 29));
                label.setBounds(130,120,200,25);

                JLabel label1 = new JLabel("Логин");
                reg.getContentPane().add(label1);
                label1.setBounds(90,145,200,25);

                JLabel label2 = new JLabel("Пароль");
                reg.getContentPane().add(label2);
                label2.setBounds(80,165,200,25);

                JButton confirm_button = new JButton("Подтвердить");
                reg.getContentPane().add(confirm_button);
                confirm_button.setBounds(130,190,200,20);

                confirm_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });

                JButton exit = new JButton("Обратно в меню");
                reg.getContentPane().add(exit);
                exit.setBounds(150,230,150,15);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reg.setVisible(false);
                        frame.setVisible(true);
                    }
                });
            }
        });

// секция игр

        JLabel play_cotegory = new JLabel("Выберите игру");
        frame.getContentPane().add(play_cotegory);
        play_cotegory.setBounds(30,80,200,20);
        play_cotegory.setFont(new Font("Italic", Font.BOLD, 15));

// камень ножницы бумага

        JButton paper_rock_cut = new JButton("Камень ножницы бумага");
        frame.getContentPane().add(paper_rock_cut);
        paper_rock_cut.setBounds(30,100,200,20);

        paper_rock_cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                String[] play = {"Ножницы", "Бумагу", "Камень"};
                JFrame paper_cut_rock1 = new JFrame("sd");
                JLabel label = new JLabel("");
                JLabel label_text = new JLabel();
                paper_cut_rock1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paper_cut_rock1.setLayout(null);
                paper_cut_rock1.setSize(new Dimension(500, 500));

                JButton rock = new JButton("Камень");
                rock.setBounds(125, 142, 200, 20);
                paper_cut_rock1.getContentPane().add(rock);
                paper_cut_rock1.setLocationRelativeTo(null);
                rock.setBackground(Color.lightGray);

                JButton paper = new JButton("Бумага");
                paper.setBounds(125, 165, 200, 20);
                paper_cut_rock1.getContentPane().add(paper);
                paper.setBackground(Color.lightGray);

                JButton cut = new JButton("Ножницы");
                cut.setBounds(125, 188, 200, 20);
                paper_cut_rock1.getContentPane().add(cut);
                cut.setBackground(Color.lightGray);


                paper_cut_rock1.getContentPane().add(label);
                paper_cut_rock1.getContentPane().add(label_text);
                label_text.setText("Бот загадал Камень/Ножницы/Бумага,\n отгадайте, что он загадал");
                label_text.setBounds(55, 30, 400, 200);
                label.setOpaque(false);

                paper.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index_play = random.nextInt(play.length);
                        String final_index = play[index_play];
                        System.out.println(final_index);
                        String c = play[1];
                        if (c == final_index) {
                            label.setBounds(125, 130, 250, 200);
                            label.setText("Вы угадали, " + "Бот загадал: " + final_index);
                        } else {
                            label.setBounds(125, 130, 250, 200);
                            label.setText("Вы не угадали, " + "Бот загадал: " + final_index);
                        }
                    }
                });
                rock.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index_play = random.nextInt(play.length);
                        String final_index = play[index_play];
                        System.out.println(final_index);
                        String c = play[2];
                        if (c == final_index) {
                            label.setBounds(125, 130, 250, 200);
                            label.setText("Вы угадали, " + "Бот загадал: " + final_index);
                        } else {
                            label.setBounds(125, 130, 250, 200);
                            label.setText("Вы не угадали, " + "Бот загадал: " + final_index);
                        }
                    }
                });
                cut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index_play = random.nextInt(play.length);
                        String final_index = play[index_play];
                        System.out.println(final_index);
                        String c = play[0];
                        if (c == final_index) {
                            label.setBounds(125, 130, 250, 200);
                            label.setText("Вы угадали, " + "Бот загадал: " + final_index);
                        } else {
                            label.setBounds(125, 130, 250, 200);
                            label.setText("Вы не угадали, " + "Бот загадал: " + final_index);
                        }
                    }
                });
                JButton exit = new JButton("Обратно в меню");
                paper_cut_rock1.getContentPane().add(exit);
                exit.setBounds(150,230,150,15);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        paper_cut_rock1.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                paper_cut_rock1.setVisible(true);
            }
        });

        // Угадайка

        JButton randoms = new JButton("Угадайка");
        frame.getContentPane().add(randoms);
        randoms.setBounds(30, 120, 200,20);

        randoms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ugadaika_frame = new JFrame("Угадайка");
                JLabel label = new JLabel("");
                JTextArea textArea = new JTextArea();
                JLabel label_text = new JLabel();
                ugadaika_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ugadaika_frame.setLayout(null);
                ugadaika_frame.setSize(new Dimension(500,500));
                ugadaika_frame.setVisible(true);
                JButton button = new JButton("Подтверждение");
                button.setBounds(125,120,200,20);
                ugadaika_frame.getContentPane().add(button);
                ugadaika_frame.setLocationRelativeTo(null);
                textArea.setBounds(125,100,200,20);
                ugadaika_frame.getContentPane().add(textArea);
                ugadaika_frame.getContentPane().add(label);
                ugadaika_frame.getContentPane().add(label_text);
                label_text.setText("Введите число");
                label_text.setBounds(125, -10,200,200);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random random = new Random();
                        int ss = random.nextInt(10);
                        System.out.println(ss);

                        int a = Integer.parseInt(textArea.getText());
                        System.out.println(a);
                        if (ss == a){
                            label.setText("Вы победили");
                            label.setBounds(125,50,200,200);
                        }
                        else {
                            label.setText("Анлак, число было: " + ss + ", а вы ввели " + a);
                            label.setBounds(125,50,200,200);
                        }
                    }
                });
                JButton exit = new JButton("Обратно в меню");
                ugadaika_frame.getContentPane().add(exit);
                exit.setBounds(150,250,150,15);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ugadaika_frame.setVisible(false);
                        frame.setVisible(true);
                    }
                });
            }
        });

        frame.setVisible(true);
    }
}


