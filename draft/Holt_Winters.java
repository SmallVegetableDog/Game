package draft;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Holt_Winters {


    /**
     * 一次指数平滑法  只适用于  水平型历史数据  的  预测，而不适用  于  斜坡型线性    趋势    历史数据的预测
     * 二次移动平均法的原理完全适用于二次指数平滑法，即对于斜坡型的历史数据，历史数据和一次指数平滑值的差值与一次指数平滑值和二次指数平滑值的差值基本相同
     * 三次是支持抛物线
     * <p>
     * 系数α的确定
     * 指数平滑法的计算中，关键是α的取值大小，但α的取值又容易受主观影响，因此合理确定α的取值方法十分重要，一般来说，如果数据波动较大，α值应取大一些，可以增加近期数据对预测结果的影响。如果数据波动平稳，α值应取小一些。理论界一般认为有以下方法可供选择：
     * 经验判断法。这种方法主要依赖于时间序列的发展趋势和预测者的经验做出判断。
     * 1、当时间序列呈现较稳定的水平趋势时，应选较小的α值，一般可在0.05～0.20之间取值；
     * 2、当时间序列有波动，但长期趋势变化不大时，可选稍大的α值，常在0.1～0.2之间取值；
     * 3、当时间序列波动很大，长期趋势变化幅度较大，呈现明显且迅速的上升或下降趋势时，宜选择较大的α值，如可在0.6～0.8间选值，以使预测模型灵敏度高些，能迅速跟上数据的变化；
     * 2、当时间序列数据是上升（或下降）的发展趋势类型，α应取较大的值，在0.6~1之间。
     * 试算法。根据具体时间序列情况，参照经验判断法，来大致确定额定的取值范围，然后取几个α值进行试算，比较不同α值下的预测标准误差，选取预测标准误差最小的α。
     * 在实际应用中预测者应结合对预测对象的变化规律做出定性判断且计算预测误差，并要考虑到预测灵敏度和预测精度是相互矛盾的，必须给予二者一定的考虑，采用折中的α值
     */

    public static double[] primary_index(double a, double data[][]) {
        List<Double> pi = new ArrayList<Double>();
        double[] result = new double[data.length];
        double s1 = 0.0;
        double st = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (j < 3) {
                    s1 += data[i][j];
                    if (data[0].length < 20)
                        st = s1 / 3;
                    else
                        st = data[i][0];
                }
            }
            pi.add(st);
            for (int k = 0; k < data[0].length; k++) {
                pi.add(a * data[i][k] + (1 - a) * pi.get(k));
            }
            result[i] = pi.get(pi.size() - 1);
        }
        return result;
    }

    public static double[] get2_value(double data[][], int t) {

        double a = 0.3;//指数平滑系数
        List<Double> S_1 = new ArrayList<Double>();
        List<Double> S2_1_new = new ArrayList<Double>();
        List<Double> S2_2_new = new ArrayList<Double>();
        double[] pre_values = new double[data.length];
        double s1 = 0.0;
        double st = 0.0;
        double at = 0.0;
        double bt = 0.0;
        double xt = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[0].length; j++) {

                if (j < 2) {
                    s1 += data[i][j - 1];
                    if (data[0].length < 20)
                        st = s1 / 3;
                    else
                        st = data[i][0];
                }
            }
            S_1.add(st);//初始值
            for (int k = 0; k < data[0].length; k++) {
                if (k == 0)
                    S2_1_new.add(a * data[i][k] + (1 - a) * S_1.get(k));
                else
                    S2_1_new.add(a * data[i][k] + (1 - a) * S2_1_new.get(k - 1));
            }
            for (int l = 0; l < data[0].length; l++) {
                if (l == 0)
                    S2_2_new.add(a * S2_1_new.get(l) + (1 - a) * S_1.get(l));
                else
                    S2_2_new.add(a * S2_1_new.get(l) + (1 - a) * S2_2_new.get(l - 1));
            }
            at = S2_1_new.get(S2_1_new.size() - 1) * 2 - S2_2_new.get(S2_2_new.size() - 1);
            bt = a / (1 - a) * (S2_1_new.get(S2_1_new.size() - 1) - S2_2_new.get(S2_2_new.size() - 1));
            xt = at + bt * t;
            pre_values[i] = xt;
        }


        return pre_values;
    }

    public static double[] get3_value(double data[][], int t) {
        double a = 0.25;//指数平滑系数
        List<Double> S_1 = new ArrayList<Double>();
        List<Double> S3_1_new = new ArrayList<Double>();
        List<Double> S3_2_new = new ArrayList<Double>();
        List<Double> S3_3_new = new ArrayList<Double>();
        double[] pre_values = new double[data.length];
        double s1 = 0.0;
        double st = 0.0;
        double at = 0.0;
        double bt = 0.0;
        double xt = 0.0;
        double ct = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[0].length; j++) {

                if (j < 2) {
                    s1 += data[i][j - 1];
                    if (data[0].length < 20)
                        st = s1 / 3;//小于20个数据，取前3个的平均值
                    else
                        st = data[i][0];//否则取第一个
                }
            }
            S_1.add(st);//初始值
            for (int k = 0; k < data[0].length; k++) {
                if (k == 0)
                    S3_1_new.add(a * data[i][k] + (1 - a) * S_1.get(k));
                else
                    S3_1_new.add(a * data[i][k] + (1 - a) * S3_1_new.get(k - 1));
            }
            for (int l = 0; l < data[0].length; l++) {
                if (l == 0)
                    S3_2_new.add(a * S3_1_new.get(l) + (1 - a) * S_1.get(l));
                else
                    S3_2_new.add(a * S3_1_new.get(l) + (1 - a) * S3_2_new.get(l - 1));
            }
            for (int j = 0; j < data[0].length; j++) {
                if (j == 0)
                    S3_3_new.add(a * S3_2_new.get(j) + (1 - a) * S_1.get(j));
                else
                    S3_3_new.add(a * S3_2_new.get(j) + (1 - a) * S3_3_new.get(j - 1));
            }
            at = S3_1_new.get(S3_1_new.size() - 1) * 3 - S3_2_new.get(S3_2_new.size() - 1) * 3 + S3_3_new.get(S3_3_new.size() - 1);
            bt = (a / (2 * Math.pow((1 - a), 2))) * ((6 - 5 * a) * S3_1_new.get(S3_1_new.size() - 1) - 2 * (5 - 4 * a) * S3_2_new.get(S3_2_new.size() - 1) + (4 - 3 * a) * S3_3_new.get(S3_3_new.size() - 1));
            ct = (Math.pow(a, 2) / (2 * Math.pow((1 - a), 2))) * (S3_1_new.get(S3_1_new.size() - 1) - 2 * S3_2_new.get(S3_2_new.size() - 1) + S3_3_new.get(S3_3_new.size() - 1));
            xt = at + bt * t + ct * Math.pow(t, 2);
            pre_values[i] = xt;
        }
        return pre_values;
    }

    @Test
    public void test() {
        double[][] data1 = {{28000}};
        double[] dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000,}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000, 33000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000, 33000, 35000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000, 33000, 35000, 30000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000, 33000, 35000, 30000, 39000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000, 33000, 35000, 30000, 39000, 33000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);

        data1 = new double[][]{{28000, 30000, 32000, 25000, 33000, 35000, 30000, 39000, 33000, 15000}};
        dd1 = Holt_Winters.primary_index(0.4, data1);
        displayArr(dd1);
    }

    public void displayArr(double[] dArr) {
        for (double d : dArr) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}