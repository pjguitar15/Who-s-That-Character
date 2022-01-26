import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

public class Silhouette {
    private static JButton guessBtn;
    private static JButton nextBtn;
    private GridBagConstraints gcon = new GridBagConstraints();
    private static JLabel label;
    private static JTextField textField;
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private static JLabel imageLabel = new JLabel();
    private JFrame frame = new JFrame();

    private static String userAnswer = "";
    private static boolean nextIsTrue = false;

    public Silhouette() {
        // frame
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setTitle("Silhouette");

        // left panel
        leftPanel.add(imageLabel);
        leftPanel.setBackground(Color.white);
        frame.add(leftPanel, BorderLayout.WEST);

        // right panel
        rightPanel.setLayout(new GridBagLayout());
        gcon.insets = new Insets(0, 5, 15, 5); // top, left, bottom, right

        // label
        label = new JLabel("WHO'S THAT CHARACTER");
        gcon.gridx = 0;
        gcon.gridy = 0;
        rightPanel.add(label, gcon);
        label.setFont(new Font("Lemon Milk", Font.BOLD, 32));
        label.setForeground(Color.BLACK);

        // textfield
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        gcon.gridx = 0;
        gcon.gridy = 1;
        rightPanel.add(textField, gcon);

        // guess button
        guessBtn = new JButton("Guess");
        gcon.gridx = 0;
        gcon.gridy = 2;
        rightPanel.add(guessBtn, gcon);
        rightPanel.setPreferredSize(new Dimension(550, 400));
        rightPanel.setBackground(Color.white);
        frame.add(rightPanel, BorderLayout.CENTER);

        // next button
        nextBtn = new JButton("Next");
        gcon.gridx = 0;
        gcon.gridy = 2;
        rightPanel.add(nextBtn, gcon);
        nextBtn.setVisible(false);

        ImageIcon ii = new ImageIcon(Silhouette.class.getResource("images//Silhouette Ahri.png")); // get img url
        Image img = ii.getImage();
        imageLabel.setSize(300, 300);
        Image imgScale = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageLabel.setIcon(scaledIcon);
        imageLabel.setBorder(BorderFactory.createCompoundBorder(
                imageLabel.getBorder(),
                BorderFactory.createEmptyBorder(20, 0, 20, 0))); // Top, Left, Bottom, Right

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Silhouette();
        gameLogic();
    }


    public static void imageSizeFix(String url) {
        ImageIcon ii = new ImageIcon(Silhouette.class.getResource(url)); // get img url
        Image img = ii.getImage();
        imageLabel.setSize(300, 300);
        Image imgScale = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageLabel.setIcon(scaledIcon);
    }

    public static void gameLogic() {
        Questions questions = new Questions();
        for (int i = 0; i < questions.getQuestions().size(); i++) {
            // invoke image size fix method
            imageSizeFix(questions.getQuestions().get(i).getSilImgUrl());

            boolean isTrue = false;
            // while loop to stop moving on to next question
            while (!userAnswer.equalsIgnoreCase(questions.getQuestions().get(i).getAnswer())) {
                // action listener
                guessBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userAnswer = textField.getText();
                    }
                });
            }
            textField.setText("");

            ImageIcon ii = new ImageIcon(Silhouette.class.getResource(questions.getQuestions().get(i).getAnsImgUrl())); // get img url
            Image img = ii.getImage();
            imageLabel.setSize(300, 300);
            Image imgScale = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            imageLabel.setIcon(scaledIcon);

            guessBtn.setVisible(false);
            textField.setVisible(false);
            nextBtn.setVisible(true);
            label.setText("You got it right!");
            nextIsTrue = false;

            while (!nextIsTrue) {
                nextBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nextIsTrue = true;
                    }
                });
            }


            guessBtn.setVisible(true);
            textField.setVisible(true);
            nextBtn.setVisible(false);
            label.setText("Who's that Character?");
        }
        guessBtn.setVisible(false);
        textField.setVisible(false);
        label.setText("Congratulations!");
    }
}