package core;

import org.apache.log4j.Logger;
/**.
 * 
 * @author 
 *
 */

public class BaseUtil  {
  /**.
  * 
  */
  public static final Logger LOG = Logger.getLogger(BaseUtil.class.getName());   
  /**.
  * 
  * 
  * @return new String {month, year}
  */
  
  public String[] monthYearParsExpire(final String expire) {

    // default month - December
    int monthExpireParsed = 12;
    String month = null;

    // default year - 2026
    String year = "2026";

    if (expire != null && !expire.isEmpty()) {
      // default Year - 2022
      // int yearExpireParsed = 22;

      if (expire.length() == 3) {
        monthExpireParsed = Integer.parseInt(expire.substring(0, 1));
        year = "20" + expire.substring(1); 
        
      } else if (expire.length() == 4) {
        monthExpireParsed = Integer.parseInt(expire.substring(0, 2));
        year = "20" + expire.substring(2);

      } else if (expire.length() < 3) {
        final String msg = "Unknown Expired [" + expire + "] for credit card";
        throw new IllegalArgumentException(msg);
      }

      switch (monthExpireParsed) {
        case 1:
          month = "January - 01";
          break;

        case 2:
          month = "February - 02";
          break;

        case 3:
          month = "March - 03";
          break;

        case 4:
          month = "April - 04";
          break;

        case 5:
          month = "May - 05";
          break;

        case 6:
          month = "June - 06";
          break;

        case 7:
          month = "July - 07";
          break;

        case 8:
          month = "August - 08";
          break;

        case 9:
          month = "September - 09";
          break;

        case 10:
          month = "October - 10";
          break;

        case 11:
          month = "November - 11";
          break;

        case 12:
          month = "December - 12";
          break;
        
        default:
          final String msg = "Unknown Month [" + monthExpireParsed + "]";
          LOG.info(msg);
          throw new IllegalArgumentException(msg);

      }
    }
    // System.out.println("month "+month);
    // System.out.println("year "+year);
    return new String[] { month, year };
  }
  /**.
   **/
  
  public boolean isParamUseful(final String... params) {
    boolean status = false;

    outOfLoop: for (final String tmp : params) {
      if (tmp != null && !tmp.isEmpty() && !tmp.equals(" ")) {
        status = true;
        } else {
        status = false;
        LOG.warn("Was found 'null' or 'empty' parametrs.");
        break outOfLoop;
        }
      }

    LOG.info("Input parametr is not null");
    return status;
  }
  
}
