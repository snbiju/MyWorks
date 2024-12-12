package com.app.codes.php;

public class PhpToJava {
    /*public static void main(String[] args) {
        HttpSession session = new StandardSession(null);
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from address_table where email=''");
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                String currentDateTime = dateFormat.format(currentDate) + " " + timeFormat.format(currentDate);
                String sql35 = "select type,empl_brnch from signup where email='" + email + "'";
                ResultSet resultSet35 = statement.executeQuery(sql35);
                if (resultSet35.next()) {
                    String type = resultSet35.getString("type");
                    String empl_brnch = resultSet35.getString("empl_brnch");
                    if (type.equals("admin")) {
                        if (email != null && !email.isEmpty() && session.getAttribute("scrty_key_new") != null && !session.getAttribute("scrty_key_new").isEmpty() && session.getAttribute("scrty_key") != null && !session.getAttribute("scrty_key").isEmpty()) {
                            System.out.println("<script>top.window.location = 'adminhome.php'</script>");
                        } else if (email != null && !email.isEmpty() && session.getAttribute("scrty_key_new") != null && session.getAttribute("scrty_key_new").isEmpty() && session.getAttribute("scrty_key") != null && session.getAttribute("scrty_key").isEmpty()) {
                            System.out.println("<script>top.window.location = 'phpfiles/lgn_vrfctn.php'</script>");
                        } else if (email != null && !email.isEmpty() && session.getAttribute("scrty_key_new") != null && !session.getAttribute("scrty_key_new").isEmpty() && session.getAttribute("scrty_key") != null && session.getAttribute("scrty_key").isEmpty()) {
                            System.out.println("<script>top.window.location = 'admin_security.php'</script>");
                        }
                    } else if (type.equals("employee")) {
                        String sql26 = "select email from signup where admn_crnt_brnch='" + empl_brnch + "' and type='admin'";
                        ResultSet resultSet26 = statement.executeQuery(sql26);
                        if (resultSet26.next()) {
                            String email26 = resultSet26.getString("email");
                            String sql27 = "select pckg_id from admn_usr_bsns_pckg_slct where email='" + email26 + "' and pckg_book_stat='on'";
                            ResultSet resultSet27 = statement.executeQuery(sql27);
                            if (resultSet27.next()) {
                                String pckg_id27 = resultSet27.getString("pckg_id");
                                String sql28 = "select brnch_two_fctr_id from admn_brnch_two_fctr_stat where admn_brnch='" + empl_brnch + "' and tw_fctr_stat='on'";
                                ResultSet resultSet28 = statement.executeQuery(sql28);
                                if (resultSet28.next()) {
                                    String sql29 = "select two_fctr_config from admntr_bsns_pckg_itms_usr where pckg_id='" + pckg_id27 + "' and email='" + email26 + "'";
                                    ResultSet resultSet29 = statement.executeQuery(sql29);
                                    if (resultSet29.next()) {
                                        String db_altr_nme = "digital_yoke_sltns" + empl_brnch;
                                        Connection connection_nw = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_altr_nme, "username", "password");
                                        String sql30 = "select nw_stat from admn_empl_nw_stat where email='" + email + "'";
                                        ResultSet resultSet30 = connection_nw.createStatement().executeQuery(sql30);
                                        if (resultSet30.next()) {
                                            String sql37 = "select jb_ctgry from admn_empl_ctgry_empl where empl_mail='" + email + "' and admn_brnch='" + empl_brnch + "'";
                                            ResultSet resultSet37 = connection_nw.createStatement().executeQuery(sql37);
                                            if (resultSet37.next()) {
                                                String jb_ctgry37 = resultSet37.getString("jb_ctgry");
                                                String sql38 = "select * from admn_empl_ctgry_prmsn_nw where empl_ctgry='" + jb_ctgry37 + "'";
                                                ResultSet resultSet38 = connection_nw.createStatement().executeQuery(sql38);
                                                if (resultSet38.next()) {
                                                    if (resultSet38.getString("csh_rgstr_main") == null || resultSet38.getString("csh_rgstr_main").isEmpty()) {
                                                        if (email != null && !email.isEmpty() && session.getAttribute("scrty_key_new") != null && !session.getAttribute("scrty_key_new").isEmpty() && session.getAttribute("scrty_key") != null && !session.getAttribute("scrty_key").isEmpty()) {
                                                            System.out.println("<script>top.window.location = 'employeehome.php'</script>");
                                                        }
                                                        if (email != null && !email.isEmpty() && session.getAttribute("scrty_key_new") != null && session.getAttribute("scrty_key_new").isEmpty() && session.getAttribute("scrty_key") != null && session.getAttribute("scrty_key").isEmpty()) {
                                                            if (resultSet29.getString("two_fctr_config") != null && resultSet29.getString("two_fctr_config").equals("on")) {
                                                                if (resultSet28.getString("brnch_two_fctr_id") != null && !resultSet28.getString("brnch_two_fctr_id").isEmpty()) {
                                                                    String sql31 = "select admn_empl_jbttl from employee_payroll where admn_empl_mail='" + email + "' and empl_brnch='" + empl_brnch + "'";
                                                                    ResultSet resultSet31 = connection_nw.createStatement().executeQuery(sql31);
                                                                    if (resultSet31.next()) {
                                                                        String admn_empl_jbttl31 = resultSet31.getString("admn_empl_jbttl");
                                                                        String sql32 = "select admn_itm_ctgry_dprtmnt from admn_itm_ctgry where admn_itm_ctgry_id='" + admn_empl_jbttl31 + "'";
                                                                        ResultSet resultSet32 = connection_nw.createStatement().executeQuery(sql32);
                                                                        if (resultSet32.next()) {
                                                                            String admn_itm_ctgry_dprtmn32 = resultSet32.getString("admn_itm_ctgry_dprtmnt");
                                                                            String sql33 = "";
                                                                            if (admn_itm_ctgry_dprtmn32.equals("administration")) {
                                                                                sql33 = "select scrty_nme,scrty_nmbr from admn_scrty_nmbr where email='" + email26 + "' and scrty_admnstrn='on'";
                                                                            } else if (admn_itm_ctgry_dprtmn32.equals("production")) {
                                                                                sql33 = "select scrty_nme,scrty_nmbr from admn_scrty_nmbr where email='" + email26 + "' and scrty_prdctn='on'";
                                                                            } else if (admn_itm_ctgry_dprtmn32.equals("sales")) {
                                                                                sql33 = "select scrty_nme,scrty_nmbr from admn_scrty_nmbr where email='" + email26 + "' and scrty_sles='on'";
                                                                            } else if (admn_itm_ctgry_dprtmn32.equals("hr")) {
                                                                                sql33 = "select scrty_nme,scrty_nmbr from admn_scrty_nmbr where email='" + email26 + "' and scrty_hr='on'";
                                                                            } else if (admn_itm_ctgry_dprtmn32.equals("quality")) {
                                                                                sql33 = "select scrty_nme,scrty_nmbr from admn_scrty_nmbr where email='" + email26 + "' and scrty_qlt_cnrl='on'";
                                                                            } else if (admn_itm_ctgry_dprtmn32.equals("account")) {
                                                                                sql33 = "select scrty_nme,scrty_nmbr from admn_scrty_nmbr where email='" + email26 + "' and scrty_acnt='on'";
                                                                            }
                                                                            ResultSet resultSet33 = connection_nw.createStatement().executeQuery(sql33);
                                                                            if (resultSet33.next()) {
                                                                                if (resultSet33.getString("scrty_nmbr") == null || resultSet33.getString("scrty_nmbr").isEmpty()) {
                                                                                    String sql30 = "select nw_stat from admn_empl_nw_stat where email='" + email + "'";
                                                                                    ResultSet resultSet30 = connection_nw.createStatement().executeQuery(sql30);
                                                                                    if (resultSet30.next()) {
                                                                                        if (resultSet30.getString("nw_stat") == null || resultSet30.getString("nw_stat").isEmpty()) {
                                                                                            System.out.println("<script>top.window.location = 'phpfiles/lgn_vrfctn.php'</script>");
                                                                                        } else {
                                                                                            System.out.println("<script>top.window.location = 'employeehome-view-empl_nwps_chng.htm'</script>");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    System.out.println("<script>top.window.location = 'phpfiles/lgn_vrfctn.php'</script>");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    session.setAttribute("scrty_key_new", "123456");
                                                                    String sql30 = "select nw_stat from admn_empl_nw_stat where email='" + email + "'";
                                                                    ResultSet resultSet30 = connection_nw.createStatement().executeQuery(sql30);
                                                                    if (resultSet30.next()) {
                                                                        if (resultSet30.getString("nw_stat") == null || resultSet30.getString("nw_stat").isEmpty()) {
                                                                            System.out.println("<script>top.window.location = 'employeehome-view-empl_dsh_brd.htm'</script>");
                                                                        } else {
                                                                            System.out.println("<script>top.window.location = 'employeehome-view-empl_nwps_chng.htm'</script>");
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                session.setAttribute("scrty_key_new", "123456");
                                                                String sql30 = "select nw_stat from admn_empl_nw_stat where email='" + email + "'";
                                                                ResultSet resultSet30 = connection_nw.createStatement().executeQuery(sql30);
                                                                if (resultSet30.next()) {
                                                                    if (resultSet30.getString("nw_stat") == null || resultSet30.getString("nw_stat").isEmpty()) {
                                                                        System.out.println("<script>top.window.location = 'employeehome-view-empl_dsh_brd.htm'</script>");
                                                                    } else {
                                                                        System.out.println("<script>top.window.location = 'employeehome-view-empl_nwps_chng.htm'</script>");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (email != null && !email.isEmpty() && session.getAttribute("scrty_key_new") != null && !session.getAttribute("scrty_key_new").isEmpty() && session.getAttribute("scrty_key") != null && session.getAttribute("scrty_key").isEmpty()) {
                                                            String sql30 = "select nw_stat from admn_empl_nw_stat where email='" + email + "'";
                                                            ResultSet resultSet30 = connection_nw.createStatement().executeQuery(sql30);
                                                            if (resultSet30.next()) {
                                                                if (resultSet30.getString("nw_stat") == null || resultSet30.getString("nw_stat").isEmpty()) {
                                                                    System.out.println("<script>top.window.location = 'employeehome-view-empl_dsh_brd.htm'</script>");
                                                                } else {
                                                                    System.out.println("<script>top.window.location = 'employeehome-view-empl_nwps_chng.htm'</script>");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        String sql45 = "select empl_cntr_no_org from employee_payroll where admn_empl_mail='" + email + "'";
                                                        ResultSet resultSet45 = connection_nw.createStatement().executeQuery(sql45);
                                                        if (resultSet45.next()) {
                                                            String empl_cntr_no_org45 = resultSet45.getString("empl_cntr_no_org");
                                                            String sql46 = "select csh_cntr_id from admn_csh_cntr_dtls where empl_mail='" + email + "' and cntr_id='" + empl_cntr_no_org45 + "' order by csh_cntr_id DESC limit 0,1";
                                                            ResultSet resultSet46 = connection_nw.createStatement().executeQuery(sql46);
                                                            if (resultSet46.next()) {
                                                                String csh_cntr_id46 = resultSet46.getString("csh_cntr_id");
                                                                String sql47 = "update admn_csh_cntr_dtls set auto_lgot='on' where csh_cntr_id='" + csh_cntr_id46 + "'";
                                                                connection_nw.createStatement().executeUpdate(sql47);
                                                                String sql39 = "update signup set scrty_stat='' where email='" + email + "'";
                                                                statement.executeUpdate(sql39);
                                                                session.setAttribute("scrty_key", "");
                                                                String sql53 = "select cntr_empl_id from admn_cntr_empl_stat where cntr_id='" + empl_cntr_no_org45 + "' and log_stat='on' and cntr_mail='" + email + "'";
                                                                ResultSet resultSet53 = statement.executeQuery(sql53);
                                                                if (resultSet53.next()) {
                                                                    System.out.println("<script>top.window.location = 'employeehome-view-empl_dsh_brd.htm'</script>");
                                                                } else {
                                                                    String sql54 = "update signup set scrty_stat='' where email='" + email + "'";
                                                                    statement.executeUpdate(sql54);
                                                                    String sql55 = "delete from lgn_stat_sctn where email='" + email + "'";
                                                                    statement.executeUpdate(sql55);
                                                                    String sql56 = "update login set log_stats='1' where email='" + email + "'";
                                                                    statement.executeUpdate(sql56);
                                                                    String sql57 = "update admn_cntr_empl_stat set log_stat='' where cntr_id='" + empl_cntr_no_org45 + "' and cntr_mail='" + email + "' and admn_brnch='" + empl_brnch + "'";
                                                                    statement.executeUpdate(sql57);
                                                                    session.invalidate();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            String sql41 = "SET GLOBAL sql_mode=''";
            statement.executeUpdate(sql41);
            String sql14 = "select brnch_id,email from admn_brnch";
            ResultSet resultSet14 = statement.executeQuery(sql14);
            if (resultSet14.next()) {
                while (resultSet14.next()) {
                    String brnch_id14 = resultSet14.getString("brnch_id");
                    String email14 = resultSet14.getString("email");
                    String db_altr_nme = "digital_yoke_sltns" + brnch_id14;
                    Connection connection_nw = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_altr_nme, "username", "password");
                    String sql213 = "select frm_cntry from address_table where email='" + email14 + "'";
                    ResultSet resultSet213 = statement.executeQuery(sql213);
                    if (resultSet213.next()) {
                        String frm_cntry213 = resultSet213.getString("frm_cntry");
                        String sql156 = "select fncl_strt_dte,fncl_end_dte,strt_dte_nw,end_dte_nw from admn_fncl_yr_slct where admn_brnch='" + brnch_id14 + "'";
                        ResultSet resultSet156 = statement.executeQuery(sql156);
                        if (resultSet156.next()) {
                            String strt_dte_nw156 = resultSet156.getString("strt_dte_nw");
                            String end_dte_nw156 = resultSet156.getString("end_dte_nw");
                            Date combinedDT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strt_dte_nw156);
                            if (currentDate.after(combinedDT) && currentDate.before(end_dte_nw156)) {
                            } else {
                                String sql214 = "select * from admnstr_fncl_yr where cntry_slct='" + frm_cntry213 + "' and '" + currentDateTime + "' between admn_yr_strt_dte and admn_yr_end_dte";
                                ResultSet resultSet214 = statement.executeQuery(sql214);
                                if (resultSet214.next()) {
                                    String admn_yr_strt_dte214 = resultSet214.getString("admn_yr_strt_dte");
                                    String admn_yr_strt_dte214_nw = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(admn_yr_strt_dte214));
                                    String admn_yr_end_dte214 = resultSet214.getString("admn_yr_end_dte");
                                    String admn_yr_end_dte214_nw = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(admn_yr_end_dte214));
                                    String sql36 = "select fncl_yr_crt_id from admn_fncl_yr_crt where admn_brnch='" + brnch_id14 + "' and fncl_strt_dte='" + admn_yr_strt_dte214_nw + "' and fncl_end_dte='" + admn_yr_end_dte214_nw + "'";
                                    ResultSet resultSet36 = statement.executeQuery(sql36);
                                    if (!resultSet36.next()) {
                                        String sql15 = "insert into admn_fncl_yr_crt(email,admn_brnch,fncl_strt_dte,fncl_end_dte,strt_dte_nw,end_dte_nw) values('" + email14 + "','" + brnch_id14 + "','" + admn_yr_strt_dte214_nw + "','" + admn_yr_end_dte214_nw + "','" + admn_yr_strt_dte214 + "','" + admn_yr_end_dte214 + "')";
                                        statement.executeUpdate(sql15);
                                    }
                                    String sql16 = "select fncl_yr_crt_id from admn_fncl_yr_crt where email='" + email14 + "' and admn_brnch='" + brnch_id14 + "' order by fncl_yr_crt_id DESC limit 0,1";
                                    ResultSet resultSet16 = statement.executeQuery(sql16);
                                    if (resultSet16.next()) {
                                        String fncl_yr_crt_id16 = resultSet16.getString("fncl_yr_crt_id");
                                        String sql17 = "select fncl_yr_id from admn_fncl_yr_slct where admn_brnch='" + brnch_id14 + "' and fncl_strt_dte='" + admn_yr_strt_dte214_nw + "' and fncl_end_dte='" + admn_yr_end_dte214_nw + "'";
                                        ResultSet resultSet17 = statement.executeQuery(sql17);
                                        if (!resultSet17.next()) {
                                            String sql18 = "insert into admn_fncl_yr_slct(email,admn_brnch,tme_perd_id,fncl_strt_dte,fncl_end_dte,strt_dte_nw,end_dte_nw) values('" + email14 + "','" + brnch_id14 + "','" + fncl_yr_crt_id16 + "','" + admn_yr_strt_dte214_nw + "','" + admn_yr_end_dte214_nw + "','" + admn_yr_strt_dte214 + "','" + admn_yr_end_dte214 + "')";
                                            statement.executeUpdate(sql18);
                                            int frst_yr156 = Integer.parseInt(new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(admn_yr_strt_dte214_nw)));
                                            int lst_yr156 = Integer.parseInt(new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(admn_yr_end_dte214_nw)));
                                            String yr_cmbnd156 = frst_yr156 + "" + lst_yr156;
                                            int prev_frst_yr156 = frst_yr156 - 1;
                                            int prev_lst_yr156 = lst_yr156 - 1;
                                            String prev_yr_cmbnd156 = prev_frst_yr156 + "" + prev_lst_yr156;
                                            String tble_nme1 = "admn_order" + prev_yr_cmbnd156;
                                            String sql58 = "select ordr_id from " + tble_nme1 + " order by ordr_id DESC limit 0,1";
                                            ResultSet resultSet58 = connection_nw.createStatement().executeQuery(sql58);
                                            if (resultSet58.next()) {
                                                int ordr_id58 = resultSet58.getInt("ordr_id") + 1;
                                                String tble_nme2 = "admn_order" + yr_cmbnd156;
                                                String sql59 = "CREATE TABLE " + tble_nme2 + " ( ordr_id int(255) NOT NULL AUTO_INCREMENT, nw_ordr_id varchar(100) NOT NULL, qtn_no varchar(50) NOT NULL, qtn_no_dsply varchar(50) NOT NULL, prfma_no varchar(50) NOT NULL, prfma_no_dsply varchar(50) NOT NULL, admn_brnch varchar(100) NOT NULL, bsns_brnch varchar(100) NOT NULL, user_type varchar(100) NOT NULL, email varchar(100) NOT NULL, empl_mail varchar(100) NOT NULL, empl_aprv_mail varchar(100) NOT NULL, empl_cntr varchar(100) NOT NULL, empl_cntr_sesn_id varchar(100) NOT NULL, empl_cntr_aprv varchar(100) NOT NULL, empl_cntr_aprv_sesn_id varchar(100) NOT NULL, name varchar(100) NOT NULL, cstmr_id varchar(100) NOT NULL, cstmr_id_org varchar(100) NOT NULL, cstmr_house_no varchar(100) NOT NULL, cstmr_street1 varchar(100) NOT NULL, cstmr_street2 varchar(100) NOT NULL, cstmr_city varchar(100) NOT NULL, cstmr_stat varchar(100) NOT NULL, cstmr_gst varchar(100) NOT NULL, cstmr_pan varchar(100) NOT NULL, cstmr_dte_sply varchar(100) NOT NULL, cstmr_plc_sply varchar(100) NOT NULL, cstmr_trnsprt_mde varchar(100) NOT NULL, ordr_nrtn varchar(10000) DEFAULT NULL, cstmr_pincode varchar(100) NOT NULL, landline_no varchar(100) NOT NULL, mobile_no varchar(100) NOT NULL, wrk_srce varchar(100) NOT NULL, bll_no varchar(100) NOT NULL, bll_cstmr_nme varchar(100) NOT NULL, bll_cstmr_mail varchar(100) NOT NULL, bll_cstmr_adrs varchar(500) NOT NULL, bll_plc_sply varchar(100) NOT NULL, bll_dte_sply varchar(100) NOT NULL, bll_trns_mde varchar(100) NOT NULL, bll_gst_no varchar(100) NOT NULL, bll_pan_no varchar(100) NOT NULL, bll_typ varchar(100) NOT NULL, ordr_time varchar(100) NOT NULL, ordr_date varchar(100) NOT NULL, dlvry_dte varchar(100) NOT NULL, dlvry_tme varchar(100) NOT NULL, evnt_strt_time varchar(100) NOT NULL, evnt_end_time varchar(100) NOT NULL, evnt_strt_date varchar(100) NOT NULL, evnt_end_date varchar(100) NOT NULL, estmtn_stats varchar(100) NOT NULL, archv_dte varchar(100) NOT NULL, ordr_status varchar(100) NOT NULL, ran_no varchar(100) NOT NULL, PRIMARY KEY (ordr_id) )";
                                                connection_nw.createStatement().executeUpdate(sql59);
                                                String sql60 = "ALTER TABLE " + tble_nme2 + " AUTO_INCREMENT = '" + ordr_id58 + "'";
                                                connection_nw.createStatement().executeUpdate(sql60);
                                                String tble_nme3 = "bill_dtls" + prev_yr_cmbnd156;
                                                String sql61 = "select bill_id from " + tble_nme3 + " order by bill_id DESC limit 0,1";
                                                ResultSet resultSet61 = connection_nw.createStatement().executeQuery(sql61);
                                                if (resultSet61.next()) {
                                                    int bill_id61 = resultSet61.getInt("bill_id") + 1;
                                                    String tble_nme4 = "bill_dtls" + yr_cmbnd156;
                                                    String sql63 = "CREATE TABLE " + tble_nme4 + " ( bill_id int(255) NOT NULL AUTO_INCREMENT, ordr_id varchar(100) NOT NULL, admn_brnch varchar(100) NOT NULL, cstmr_id varchar(100) NOT NULL, cstmr_nme varchar(100) NOT NULL, sell_prc_sm varchar(100) NOT NULL, total varchar(100) NOT NULL, total_incl varchar(100) NOT NULL, tax1 varchar(100) NOT NULL, tax2 varchar(100) NOT NULL, tax3 varchar(100) NOT NULL, final_total varchar(100) NOT NULL, round_of varchar(100) NOT NULL, advnc1 varchar(100) NOT NULL, advnc1_dte varchar(100) NOT NULL, advnc2 varchar(100) NOT NULL, advnc2_dte varchar(100) NOT NULL, advnc3 varchar(100) NOT NULL, advnc3_dte varchar(100) NOT NULL, total_advnc varchar(100) NOT NULL, balance varchar(100) NOT NULL, itm_dscnt varchar(100) NOT NULL, flt_dscnt varchar(100) NOT NULL, disc_amnt varchar(100) NOT NULL, disc_dte varchar(100) NOT NULL, rqst_dte varchar(100) NOT NULL, rqst_tme varchar(100) NOT NULL, dlvry_dte varchar(100) NOT NULL, dlvry_tme varchar(100) NOT NULL, pymnt_typ varchar(100) NOT NULL, PRIMARY KEY (bill_id) )";
                                                    connection_nw.createStatement().executeUpdate(sql63);
                                                    String sql64 = "ALTER TABLE " + tble_nme4 + " AUTO_INCREMENT = '" + bill_id61 + "'";
                                                    connection_nw.createStatement().executeUpdate(sql64);
                                                    String tble_nme5 = "admn_estmtn_stat" + prev_yr_cmbnd156;
                                                    String sql65 = "select estmtn_stat_id from " + tble_nme5 + " order by estmtn_stat_id DESC limit 0,1";
                                                    ResultSet resultSet65 = connection_nw.createStatement().executeQuery(sql65);
                                                    if (resultSet65.next()) {
                                                        int estmtn_stat_id65 = resultSet65.getInt("estmtn_stat_id") + 1;
                                                        String tble_nme6 = "admn_estmtn_stat" + yr_cmbnd156;
                                                        String sql66 = "CREATE TABLE " + tble_nme6 + " (estmtn_stat_id int(255) NOT NULL AUTO_INCREMENT,admn_brnch varchar(100) NOT NULL,ordr_id varchar(100) NOT NULL,ordr_stat varchar(100) NOT NULL,PRIMARY KEY (estmtn_stat_id) )";
                                                        connection_nw.createStatement().executeUpdate(sql66);
                                                        String sql68 = "ALTER TABLE " + tble_nme6 + " AUTO_INCREMENT = '" + estmtn_stat_id65 + "'";
                                                        connection_nw.createStatement().executeUpdate(sql68);
                                                        String tble_nme7 = "admn_est_jbordr_lst" + prev_yr_cmbnd156;
                                                        String sql69 = "select est_jbordr_id from " + tble_nme7 + " order by est_jbordr_id DESC limit 0,1";
                                                        ResultSet resultSet69 = connection_nw.createStatement().executeQuery(sql69);
                                                        if (resultSet69.next()) {
                                                            int est_jbordr_id69 = resultSet69.getInt("est_jbordr_id") + 1;
                                                            String tble_nme8 = "admn_est_jbordr_lst" + yr_cmbnd156;
                                                            String sql70 = "CREATE TABLE " + tble_nme8 + " (est_jbordr_id int(255) NOT NULL AUTO_INCREMENT,email varchar(100) NOT NULL,admn_brnch varchar(100) NOT NULL,ordr_id varchar(100) NOT NULL,PRIMARY KEY (est_jbordr_id) )";
                                                            connection_nw.createStatement().executeUpdate(sql70);
                                                            String sql72 = "ALTER TABLE " + tble_nme8 + " AUTO_INCREMENT = '" + est_jbordr_id69 + "'";
                                                            connection_nw.createStatement().executeUpdate(sql72);
                                                            String tble_nme9 = "admn_ordr_jbnme" + prev_yr_cmbnd156;
                                                            String sql73 = "select ordr_jbnme_id from " + tble_nme9 + " order by ordr_jbnme_id DESC limit 0,1";
                                                            ResultSet resultSet73 = connection_nw.createStatement().executeQuery(sql73);
                                                            if (resultSet73.next()) {
                                                                int ordr_jbnme_id73 = resultSet73.getInt("ordr_jbnme_id") + 1;
                                                                String tble_nme10 = "admn_ordr_jbnme" + yr_cmbnd156;
                                                                String sql74 = "create table " + tble_nme10 + "(ordr_jbnme_id INT(255) AUTO_INCREMENT PRIMARY KEY,email VARCHAR(100) NOT NULL,admn_brnch VARCHAR(100) NOT NULL,ordr_id VARCHAR(100) NOT NULL,ordr_nme VARCHAR(100) NOT NULL)";
                                                                connection_nw.createStatement().executeUpdate(sql74);
                                                                String sql78 = "ALTER TABLE " + tble_nme10 + " AUTO_INCREMENT = '" + ordr_jbnme_id73 + "'";
                                                                connection_nw.createStatement().executeUpdate(sql78);
                                                                String tble_nme11 = "admn_jbordr_ces_amnt" + prev_yr_cmbnd156;
                                                                String sql79 = "select jbordr_ces_id from " + tble_nme11 + " order by jbordr_ces_id DESC limit 0,1";
                                                                ResultSet resultSet79 = connection_nw.createStatement().executeQuery(sql79);
                                                                if (resultSet79.next()) {
                                                                    int jbordr_ces_id79 = resultSet79.getInt("jbordr_ces_id") + 1;
                                                                    String tble_nme12 = "admn_jbordr_ces_amnt" + yr_cmbnd156;
                                                                    String sql80 = "create table " + tble_nme12 + "(jbordr_ces_id INT(255) AUTO_INCREMENT PRIMARY KEY,email VARCHAR(100) NOT NULL,admn_brnch VARCHAR(100) NOT NULL,ordr_id VARCHAR(100) NOT NULL,jbordr_ces_nme VARCHAR(100) NOT NULL,jbordr_ces_tx VARCHAR(100) NOT NULL,jbordr_ces_amnt VARCHAR(100) NOT NULL)";
                                                                    connection_nw.createStatement().executeUpdate(sql80);
                                                                    String sql82 = "ALTER TABLE " + tble_nme12 + " AUTO_INCREMENT = '" + jbordr_ces_id79 + "'";
                                                                    connection_nw.createStatement().executeUpdate(sql82);
                                                                    String tble_nme14 = "empl_ordr_dtls" + prev_yr_cmbnd156;
                                                                    String sql83 = "select empl_id from " + tble_nme14 + " order by empl_id DESC limit 0,1";
                                                                    ResultSet resultSet83 = connection_nw.createStatement().executeQuery(sql83);
                                                                    if (resultSet83.next()) {
                                                                        int empl_id83 = resultSet83.getInt("empl_id") + 1;
                                                                        String tble_nme15 = "empl_ordr_dtls" + yr_cmbnd156;
                                                                        String sql84 = "CREATE TABLE " + tble_nme15 + " (empl_id int(255) NOT NULL AUTO_INCREMENT,ordr_id varchar(100) NOT NULL,admn_brnch varchar(100) NOT NULL,online_ordr_id varchar(100) NOT NULL,cstmr_id varchar(100) NOT NULL,PRIMARY KEY (empl_id) )";
                                                                        connection_nw.createStatement().executeUpdate(sql84);
                                                                        String sql85 = "ALTER TABLE " + tble_nme15 + " AUTO_INCREMENT = '" + empl_id83 + "'";
                                                                        connection_nw.createStatement().executeUpdate(sql85);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
}


