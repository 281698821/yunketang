package cn.itsource.dto;

public class Oferr {
    private String name;
    private String time;
    private String year;
    private String month;
    private String money;

    public Oferr() {
    }

    public Oferr(String name, String time, String year, String month, String money) {
        this.name = name;
        this.time = time;
        this.year = year;
        this.month = month;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "Oferr{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    /**
     * 邮件内容常量
     */
    public static String getContent(Oferr oferr) {
        String content = "";
        if (oferr != null) {

            content = "<table width=\"1000px\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\"\n" +
                    "           style='border-collapse: collapse;font-size: 16px; color: #333;font-family:\"微软雅黑\",\"sans-serif\";'>\n" +
                    "        <tr>\n" +
                    "            <td class=\"email-head;color:#ffffff\">\n" +
                    "                <img src=\"http://thyrsi.com/t6/662/1548242083x2890174094.jpg\" width=\"1000\" height=\"116\"/>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td>\n" +
                    "                <table align=\"center\" border=\"0\" cellspacing=\"0\" cellspadding=\"0\" width=\"900\">\n" +
                    "                    <tr>\n" +
                    "                        <td colspan=\"\" height=\"8\"></td>\n" +
                    "                    </tr>\n" +
                    "                    <tr class=\"email-title\">\n" +
                    "                        <td valign=\"middle\" height=\"77px\" style=\"font-size: 30px;line-height: 77px;border-bottom:1px solid #baccd7;padding: 0;\">尊敬的<font color=\"red\">" + oferr.getName() + "</font>您好:</td>\n" +
                    "                    </tr>\n" +
                    "\n" +
                    "                    <tr>\n" +
                    "                        <td colspan=\"\">\n" +
                    "                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"760\" align=\"center\">\n" +
                    "                                <tr>\n" +
                    "                                    <td width=\"20\"></td>\n" +
                    "                                    <td width=\"1205\" height=\"58\">\n" +
                    "                                          很荣幸地通知，您已被我公司录用。请您于<font color=\"red\">" + oferr.getTime() + "</font>到我公司报到。<br />" +
                    "                                       初次签署合同期为<b>" + oferr.getYear() + "</b>年，试用期不超过" + oferr.getMonth() + "个月，入职工资：<font color=\"red\">" + oferr.getMoney() + "</font>元/月<br /><br />" +
                    "" +
                    "                                               报到时需要您提供以下入职文件：<br />\n" +
                    "                                       （1）原单位离职证明（加盖原单位印章）1份<br />" +
                    "                                       （2）二代身份证原件及复印件2份<br />" +
                    "                                       （3）学位证、毕业证原件及复印件2份<br />" +
                    "                                       （4）相关资格证书（原件及复印件2份）<br />" +
                    "                                       （5）个人彩色一寸免冠照片2张<br />" +
                    "                                       （6）入职体检证明（公司指定的体检机构）<br />" +
                    "                                           （7）公司向您特殊要求的其他文件<br /><br />" +
                    "" +
                    "                                       公司仅保留证件复印件，原件退还本人。<br /> " +
                    "                                       注意事项：<br />" +
                    "                                       社保公积金转移业务于每月15日之前办理，15日之后入职的将于下月办理；如不转移的，需填写情况说明书。<br />" +
                    "                                       以上内容如有任何疑问，请与行政人力资源部联系。\n" +
                    "                                    </td>\n" +
                    "                                </tr>\n" +
                    "                                \n" +
                    "                                <tr>\n" +
                    "                                    <td colspan=\"3\" height=\"35\"></td>\n" +
                    "                                </tr>\n" +
                    "                                \n" +
                    "                                <tr>\n" +
                    "                                    <td colspan=\"3\">\n" +
                    "                                        <table width=\"760\" style=\"font-size: 14px;color: #999;\">\n" +
                    "                                            <tr>\n" +
                    "                                                <td height=\"6\"></td>\n" +
                    "                                            </tr>\n" +
                    "                                            <tr>\n" +
                    "                                                <td height=\"25\"></td>\n" +
                    "                                            </tr>\n" +
                    "                                        </table>\n" +
                    "                                    </td>\n" +
                    "                                </tr>\n" +
                    "                            </table>\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                </table>\n" +
                    "\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        <!-- 此处之后不能再编辑 -->\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\" height=\"57\" style=\"color:#555;font-size: 14px;background-color: #b5dff9;\">\n" +
                    "                隐氏集团©2019-1-1\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "    </table>";
        }


        return content;
    }

}
