import java.util.Arrays;

/**
 * @author linpeiwen
 * @version 1.0  2020/9/9
 * @since 1.8
 * <p>
 * 会议室 https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRoom {

    /**
     * 排序比较
     * 时间 O(nlog(n)) 排序
     * 空间 O(1)
     * <p>
     * 排序之后再比较时间边界是否交叉
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}
