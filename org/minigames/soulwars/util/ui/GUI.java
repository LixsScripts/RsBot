package org.minigames.soulwars.util.ui;

import org.minigames.soulwars.core.jobs.game.combat.AttackNPC;
import org.minigames.soulwars.core.jobs.game.combat.AttackPlayer;
import org.minigames.soulwars.core.jobs.game.combat.Fighting;
import org.minigames.soulwars.core.jobs.game.combat.Heal;
import org.minigames.soulwars.core.jobs.game.misc.HealPlayer;
import org.minigames.soulwars.core.jobs.game.pickup.TakeBandages;
import org.minigames.soulwars.core.jobs.game.pickup.TakeSouls;
import org.minigames.soulwars.core.jobs.game.walking.WalkToNPC;
import org.minigames.soulwars.core.jobs.game.walking.WalkToObelisk;
import org.minigames.soulwars.core.jobs.game.walking.WalkToSupplies;
import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 22/04/13
 * Time: 01:28
 * To change this template use File | Settings | File Templates.
 */

/**
 * @author Lix
 */
public class GUI extends JFrame {
    public GUI() {
        initComponents();
    }

    private void initComponents() {
        JTabbedPane tabbedPane1 = new JTabbedPane();
        JPanel panel1 = new JPanel();
        joinOptions = new JComboBox<String>();
        JCheckBox checkFakeSwitches = new JCheckBox();
        JCheckBox useSwitching = new JCheckBox();
        JPanel panel3 = new JPanel();
        JComboBox<String> rewardChoice = new JComboBox<String>();
        JLabel label1 = new JLabel();
        JPanel panel2 = new JPanel();
        JLabel label4 = new JLabel();
        attackNPCs = new JRadioButton();
        attackPlayers = new JRadioButton();
        healPlayers = new JRadioButton();
        buryBones = new JRadioButton();
        collectSouls = new JCheckBox();
        useBandages = new JCheckBox();
        JButton btnStart = new JButton();

        setTitle("Settings");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        {
            {  // crap starts
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
               // end of crap
                panel1.setLayout(null);

                joinOptions.setModel(new DefaultComboBoxModel<String>(new String[] {
                        "Always Red (Zamorak)",
                        "Always Green (Balance)",
                        "Always Blue (Saradomin)"
                }));
                joinOptions.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel1.add(joinOptions);
                joinOptions.setBounds(75, 10, 205, joinOptions.getPreferredSize().height);
                joinOptions.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch(joinOptions.getSelectedIndex()) {
                            case 0:
                                Variables.teamStr = Variables.Objects.RED_BARRIER.getStr();
                                Variables.teamColor = "red ";
                                Variables.teamBarrierId = Variables.Objects.RED_BARRIER.getId();
                                break;
                            case 1:
                                Variables.teamStr = Variables.Objects.GREEN_PORTAL.getStr();
                                Variables.teamColor = "balanced ";
                                Variables.teamBarrierId = Variables.Objects.GREEN_PORTAL.getId();
                                break;
                            case 2:
                                Variables.teamStr = Variables.Objects.BLUE_BARRIER.getStr();
                                Variables.teamColor = "blue ";
                                Variables.teamBarrierId = Variables.Objects.BLUE_BARRIER.getId();
                                break;
                        }
                        Areas.setHomeGrave();
                    }
                });

                checkFakeSwitches.setText("Check for fake switching?");
                checkFakeSwitches.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel1.add(checkFakeSwitches);
                checkFakeSwitches.setBounds(75, 45, 205, checkFakeSwitches.getPreferredSize().height);
                checkFakeSwitches.setEnabled(false);

                useSwitching.setText("Follow real switches?");
                useSwitching.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel1.add(useSwitching);
                useSwitching.setBounds(75, 75, 205, 23);
                useSwitching.setEnabled(false);
            }
            tabbedPane1.addTab("Teams", panel1);

            {
                panel3.setLayout(null);

                rewardChoice.setModel(new DefaultComboBoxModel<>(new String[]{
                        "None",
                        "Vanguard",
                        "Battlemage",
                        "Trickster"
                }));
                rewardChoice.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel3.add(rewardChoice);
                rewardChoice.setBounds(70, 35, 205, rewardChoice.getPreferredSize().height);
                rewardChoice.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                label1.setText("Choose hybrid gear to collect");
                label1.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel3.add(label1);
                label1.setBounds(5, 5, 360, 25);
            }
            //tabbedPane1.addTab("Hybird Armour", panel3);
            {
                panel2.setLayout(null);

                label4.setText("Select the in game roles you would like to use.");
                label4.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(label4);
                label4.setBounds(new Rectangle(new Point(5, 5), label4.getPreferredSize()));

                attackNPCs.setText("Attack monsters");
                attackNPCs.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(attackNPCs);
                attackNPCs.setBounds(15, 40, 130, attackNPCs.getPreferredSize().height);
                attackNPCs.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (attackNPCs.isSelected()) {
                            attackPlayers.setSelected(false);
                            healPlayers.setSelected(false);
                            buryBones.setSelected(false);
                            useBandages.setEnabled(true);
                            collectSouls.setSelected(true);
                            collectSouls.setVisible(true);
                        }
                    }
                });

                attackPlayers.setText("Attack players");
                attackPlayers.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(attackPlayers);
                attackPlayers.setBounds(15, 65, 140, 23);
                attackPlayers.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (attackPlayers.isSelected()) {
                            attackNPCs.setSelected(false);
                            healPlayers.setSelected(false);
                            buryBones.setSelected(false);
                            useBandages.setEnabled(true);
                            collectSouls.setSelected(false);
                            collectSouls.setVisible(false);
                        }
                    }
                });

                healPlayers.setText("Heal players");
                healPlayers.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(healPlayers);
                healPlayers.setBounds(190, 65, 150, 23);
                healPlayers.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (healPlayers.isSelected()) {
                            attackNPCs.setSelected(false);
                            attackPlayers.setSelected(false);
                            buryBones.setSelected(false);
                            useBandages.setEnabled(false);
                            collectSouls.setSelected(false);
                            collectSouls.setVisible(false);
                        }
                    }
                });

                buryBones.setText("Bury bones");
                buryBones.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(buryBones);
                buryBones.setBounds(190, 40, 130, 23);
                buryBones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (buryBones.isSelected()) {
                            attackNPCs.setSelected(false);
                            attackPlayers.setSelected(false);
                            healPlayers.setSelected(false);
                            useBandages.setEnabled(false);
                            collectSouls.setSelected(false);
                            collectSouls.setVisible(false);
                        }
                    }
                });

                collectSouls.setText("Collect & dump souls");
                collectSouls.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(collectSouls);
                collectSouls.setBounds(20, 115, 140, collectSouls.getPreferredSize().height);
                collectSouls.setVisible(false);

                useBandages.setText("Use bandages");
                useBandages.setFont(new Font("Verdana", Font.PLAIN, 12));
                panel2.add(useBandages);
                useBandages.setBounds(new Rectangle(new Point(125, 140), useBandages.getPreferredSize()));
            }
            tabbedPane1.addTab("Roles", panel2);

        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(5, 15, 380, 205);

        btnStart.setText("Start");
        contentPane.add(btnStart);
        btnStart.setBounds(5, 225, 375, 30);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (attackPlayers.isSelected()) {
                    Variables.nodes.add(new AttackPlayer());
                    Variables.nodes.add(new Fighting());
                    Variables.nodes.add(new WalkToObelisk());
                } else if (attackNPCs.isSelected()) {
                    Variables.nodes.add(new AttackNPC());
                    Variables.nodes.add(new Fighting());
                    Variables.nodes.add(new WalkToNPC());
                    if (collectSouls.isSelected()) {
                        Variables.nodes.add(new TakeSouls());
                        Variables.nodes.add(new WalkToObelisk());
                    }
                } else if (buryBones.isSelected()) {
                    Variables.burying = true;
                } else if (healPlayers.isSelected()) {
                    Variables.healer = true;
                    Variables.nodes.add(new WalkToSupplies());
                    Variables.nodes.add(new TakeBandages());
                    Variables.nodes.add(new WalkToObelisk());
                    Variables.nodes.add(new HealPlayer());
                }
                if (useBandages.isSelected()) {
                    Variables.nodes.add(new WalkToSupplies());
                    Variables.nodes.add(new TakeBandages());
                    Variables.nodes.add(new Heal());
                }
                Variables.start = true;
                dispose();
            }
        });

        contentPane.setPreferredSize(new Dimension(405, 295));
        pack();
        setLocationRelativeTo(getOwner());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(405, 300);
        setVisible(true);
    }

    private JComboBox<String> joinOptions;
    private JRadioButton attackNPCs;
    private JRadioButton attackPlayers;
    private JRadioButton healPlayers;
    private JRadioButton buryBones;
    private JCheckBox collectSouls;
    private JCheckBox useBandages;
}

