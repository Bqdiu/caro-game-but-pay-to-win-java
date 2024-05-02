package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.text.html.CSS;

import CustomComponents.RadiusButton;
import CustomComponents.CustomPanel;
import CustomComponents.CustomPanelGradients;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LobbyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image img_Rank = new ImageIcon(LobbyFrame.class.getResource("/img/rank_img.png")).getImage().getScaledInstance(62, 62,Image.SCALE_SMOOTH);
	private Image img_Add_friend = new ImageIcon(LobbyFrame.class.getResource("/img/add_user.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
	private Image img_Message = new ImageIcon(LobbyFrame.class.getResource("/img/message_img.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
	private Image img_friends = new ImageIcon(LobbyFrame.class.getResource("/img/friends_img.png")).getImage().getScaledInstance(53,53,Image.SCALE_SMOOTH);
	private Image img_logout = new ImageIcon(LobbyFrame.class.getResource("/img/logout_img.png")).getImage().getScaledInstance(59, 60,Image.SCALE_SMOOTH);
	private Image img_setting = new ImageIcon(LobbyFrame.class.getResource("/img/setting_img.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
	private Image img_man = new ImageIcon(LobbyFrame.class.getResource("/img/man_img.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
	private Image img_token = new ImageIcon(LobbyFrame.class.getResource("/img/token_img.png")).getImage().getScaledInstance(45, 45,Image.SCALE_SMOOTH);
	private Image img_Shop = new ImageIcon(LobbyFrame.class.getResource("/img/shop_img.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
	private Image img_BackGroundMain = new ImageIcon(LobbyFrame.class.getResource("/img/main_lobby_img.png")).getImage().getScaledInstance(1000, 800,Image.SCALE_SMOOTH);
	private RadiusButton rdvsBot;
	private RadiusButton rdvsPlayer;
	private RadiusButton rdChooseRoom;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LobbyFrame frame = new LobbyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LobbyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 LineBorder lineBorder = new LineBorder(new Color(0, 0, 0), 1); 
		 
	     TitledBorder titledBorder = new TitledBorder(lineBorder, "Thông tin người chơi",
	     TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0));
	     titledBorder.setTitleFont(new Font("Tahoma",Font.BOLD,15));
		
		JPanel panel_container = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                        GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(0x5170FF), // Màu bắt đầu (#ff8a00)#5170ff
                        getWidth(), getHeight(), new Color(0xff66c4) // Màu kết thúc (#e52e71)#ff66c4
                );
                
                // Sơn gradient trên JPanel
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
		panel_container.setBounds(0, 0,1000, 800);
		contentPane.add(panel_container);
		panel_container.setLayout(null);
		
		JLabel lblUser = new JLabel("ADMIN");
		lblUser.setBounds(105,15,230,67);
		lblUser.setFont(new Font("Tahoma",Font.PLAIN,20));
		lblUser.setForeground(Color.black);
		panel_container.add(lblUser);
		
		JLabel lblTextToken = new JLabel("2,000");
		lblTextToken.setBounds(65,113,80,20);
		lblTextToken.setFont(new Font("Lily Script One",Font.PLAIN,20));
		lblTextToken.setForeground(Color.black);
		panel_container.add(lblTextToken);
		
		JLabel lblTextRanking = new JLabel("Ranking");
		lblTextRanking.setBounds(908, 352, 70,30);
		lblTextRanking.setFont(new Font("Lily Script One",Font.PLAIN,16));
		lblTextRanking.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextRanking.setForeground(Color.white);
		panel_container.add(lblTextRanking);
		
		JLabel lblTextAddFriend = new JLabel("Add friends");
		lblTextAddFriend.setBounds(899, 533, 82,30);
		lblTextAddFriend.setFont(new Font("Lily Script One",Font.PLAIN,16));
		lblTextAddFriend.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextAddFriend.setForeground(Color.white);
		panel_container.add(lblTextAddFriend);
		
		JLabel lblTextInbox = new JLabel("Inbox");
		lblTextInbox.setBounds(908, 440, 70,30);
		lblTextInbox.setFont(new Font("Lily Script One",Font.PLAIN,16));
		lblTextInbox.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextInbox.setForeground(Color.white);
		panel_container.add(lblTextInbox);
		
		JLabel lblTextFriends = new JLabel("Friends");
		lblTextFriends.setBounds(904, 624,82,30);
		lblTextFriends.setFont(new Font("Lily Script One",Font.PLAIN,16));
		lblTextFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextFriends.setForeground(Color.white);
		panel_container.add(lblTextFriends);
		
		JLabel lblTextShop = new JLabel("Shop");
		lblTextShop.setBounds(33, 386, 41, 28);
		lblTextShop.setFont(new Font("Lily Script One",Font.PLAIN,20));
		lblTextShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextShop.setForeground(Color.white);
		panel_container.add(lblTextShop);
		
		JLabel lblToken = new JLabel();
		lblToken.setBounds(15, 100, 45, 45);
		lblToken.setIcon(new ImageIcon(img_token));
		panel_container.add(lblToken);
		
		JLabel lblMan = new JLabel();
		lblMan.setBounds(20,25,60,60);
		lblMan.setIcon(new ImageIcon(img_man));
		panel_container.add(lblMan);
		
		JLabel lblNewLabel = new JLabel("CARO GAME");
		lblNewLabel.setFont(new Font("Knewave", Font.PLAIN, 48));
		lblNewLabel.setForeground(Color.WHITE); 
		lblNewLabel.setBounds(288, 260, 440, 130);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(0, 0, 0, 0));
		panel_container.add(lblNewLabel);
		JLabel lblSetting = new JLabel();
		lblSetting.setBounds(844, 25, 60, 59);
		lblSetting.setIcon(new ImageIcon(img_setting));
		panel_container.add(lblSetting);
		
		JLabel lblLogout = new JLabel();
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  int choice = JOptionPane.showConfirmDialog(
				            getContentPane(),
				            "Bạn có muốn đăng xuất không?",
				            "Xác nhận",
				            JOptionPane.YES_NO_OPTION
				        );
				        
				        if (choice == JOptionPane.YES_OPTION) {
				        	Login login = new Login();
				        	login.setVisible(true);
				        	dispose();
				        }			
		}
		});
		lblLogout.setIcon(new ImageIcon(img_logout));
		lblLogout.setBounds(930,25,60,60);
		panel_container.add(lblLogout);
		
		JLabel lblListFriends = new JLabel();
		
		lblListFriends.setBounds(918, 567, 53, 53);
		lblListFriends.setIcon(new ImageIcon(img_friends));
		panel_container.add(lblListFriends);
		
		JLabel lblAddFriend = new JLabel();
		lblAddFriend.setBounds(921, 474, 60, 60);
		lblAddFriend.setIcon(new ImageIcon(img_Add_friend));
		panel_container.add(lblAddFriend);
		
		JLabel lblMessage = new JLabel();
		lblMessage.setBounds(913, 381, 60, 60);
		lblMessage.setIcon(new ImageIcon(img_Message));
		panel_container.add(lblMessage);
		
		JLabel lblRank = new JLabel();
		lblRank.setBounds(914, 290, 62, 62);
		lblRank.setIcon(new ImageIcon(img_Rank));
		panel_container.add(lblRank);
		
		JLabel lblShop = new JLabel();
		lblShop.setBounds(23, 330, 60,60);
		lblShop.setIcon(new ImageIcon(img_Shop));
		panel_container.add(lblShop);
		
		
		rdvsBot = new RadiusButton();
		rdvsBot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CaroBoard bc = new CaroBoard();
				bc.setVisible(true);
				dispose();
				
			}
		});
		rdvsBot.setForeground(Color.WHITE);
		rdvsBot.setBorderColor(new Color(0xFFFFFF));
		rdvsBot.setText("VS BOT");
		rdvsBot.setFont(new Font("Tahoma",Font.PLAIN,32));
		rdvsBot.setBackground(new Color(0xF19AFF));
		rdvsBot.setBounds(368, 391, 280, 50);
		rdvsBot.setRadius(30);
		panel_container.add(rdvsBot);
		
		rdvsPlayer = new RadiusButton();
		rdvsPlayer.setRadius(30);
		rdvsPlayer.setForeground(Color.WHITE);
		rdvsPlayer.setBorderColor(new Color(0xFFFFFF));

		rdvsPlayer.setBackground(new Color(0xF19AFF));
		rdvsPlayer.setFont(new Font("Tahoma",Font.PLAIN,32));
		rdvsPlayer.setText("VS PLAYER");
		rdvsPlayer.setBounds(368, 467, 280, 50);
		panel_container.add(rdvsPlayer);
		
		rdChooseRoom = new RadiusButton();
		rdChooseRoom.setRadius(30);
		rdChooseRoom.setForeground(Color.WHITE);
		rdChooseRoom.setBorderColor(new Color(0xFFFFFF));

		rdChooseRoom.setBackground(new Color(0xF19AFF));
		rdChooseRoom.setFont(new Font("Tahoma",Font.PLAIN,32));
		rdChooseRoom.setText("CHOOSE ROOM");
		rdChooseRoom.setBounds(368, 542, 280, 50);
		panel_container.add(rdChooseRoom);
		
		CustomPanel panelcustomLeft = new CustomPanel();
		panelcustomLeft.setBounds(10, 320, 87, 93);		
		panel_container.add(panelcustomLeft);
			
		CustomPanel panelcustomRight = new CustomPanel();
		panelcustomRight.setBounds(880, 288, 120, 394); 
		panel_container.add(panelcustomRight);
		
		CustomPanel panelcustomTopRight = new CustomPanel();
		panelcustomTopRight.setBounds(803, 20,197,70);
		panel_container.add(panelcustomTopRight);
		
		CustomPanelGradients panelcustomToppLeft = new CustomPanelGradients();
        panelcustomToppLeft.setBounds(0,20,230,67);
		panel_container.add(panelcustomToppLeft);
		
		CustomPanelGradients panelcustomTopLeftBelow = new CustomPanelGradients();
		panelcustomTopLeftBelow.setBounds(-7,100,157,45);
		panel_container.add(panelcustomTopLeftBelow);
		
	     TitledBorder titledBorderBXH = new TitledBorder(null, "Bảng xếp hạng", TitledBorder.CENTER, TitledBorder.TOP, null, null);
	     titledBorderBXH.setTitleFont(new Font("Tahoma", Font.BOLD, 20));
	}
}