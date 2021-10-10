package com.ifmo.lesson2;

public class LuckyTickets {
    /*
    В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
    неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
    000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
    номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
    567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
    и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
    сколько счастливых билетов в одном рулоне?
     */
    public static void main(String[] args) {
        System.out.println(luckyTickets());
    }

    public static int luckyTickets() {
        // TODO implement

        int sum = 0;

        for (int i=1; i<=999999; i++){
            String zeros = "";
            String num = String.valueOf(i);
//            num = "0"*(6-num.length());
            for (int j=0; j<=6-num.length()-1; j++){
                zeros+="0";
            }
            num = zeros + num;
            int a1 = Integer.parseInt(String.valueOf(num.charAt(0)));
            int a2 = Integer.parseInt(String.valueOf(num.charAt(1)));
            int a3 = Integer.parseInt(String.valueOf(num.charAt(2)));
            int a4 = Integer.parseInt(String.valueOf(num.charAt(3)));
            int a5 = Integer.parseInt(String.valueOf(num.charAt(4)));
            int a6 = Integer.parseInt(String.valueOf(num.charAt(5)));
            if (a1+a2+a3==a4+a5+a6){
//                System.out.println(num);
                sum+=1;
            }
        }

        return sum;
    }
}
