package com.my.algorithm;

import com.my.algorithm.model.Label;

import java.util.*;

public class LabelSort {

    public static int[] mergeArr(int[] service, int[] local) {
        HashSet<Integer> serviceSet = new HashSet<>();
        HashSet<Integer> localSet = new HashSet<>();

        for (int num : local) localSet.add(num);
        for (int num : service) serviceSet.add(num);

        for (int i = 0, j = 0; i < service.length; i++) {
            if (!localSet.contains(service[i])) continue;
            if (serviceSet.contains(local[j])) service[i] = local[j++];
        }
        return service;
    }

    public static void main(String[] args) {
//        List<Label> serverData = new ArrayList<>();
//        ArrayList<Label> local = new ArrayList<>();
//
//        //服务端数据
//        serverData.add(new Label(999, 0, " 1111"));
//        serverData.add(new Label(888, 0, " 1111"));
//        serverData.add(new Label(1001, 1, " 1111"));
//        serverData.add(new Label(1002, 1, " 1111"));
//        //增加一个数据
//        serverData.add(new Label(1005, 1, "111"));
//        serverData.add(new Label(1003, 1, " 1111"));
//        serverData.add(new Label(1004, 1, " 1111"));
//        //本地数据
//        local.add(new Label(1004, 1, " 1111"));
//        local.add(new Label(1003, 1, " 1111"));
//        local.add(new Label(1002, 1, " 1111"));
//        local.add(new Label(1001, 1, " 1111"));
//        //删除旧数据
//        local.add(new Label(1007, 1, " 1111"));
//
//        local.add(new Label(999, 0, " 1111"));
//        local.add(new Label(888, 0, " 1111"));
//
//
//        List<Label> subList = serverData.subList(2, serverData.size());
//        //保证一致性 删除本地排序多的项
//        final Iterator<Label> iterator = local.iterator();
//        while (iterator.hasNext()) {
//            Label localItem = iterator.next();
//            if (!subList.contains(localItem)) {
//                iterator.remove();
//            }
//        }
//
//        //保证一致性 增加服务端新增的项
//        for (int i = 0; i < subList.size(); i++) {
//            Label serverItem = subList.get(i);
//            if (!local.contains(serverItem)) {
//                if (i > local.size()) {
//                    local.add(local.size(), serverItem);
//                } else {
//                    local.add(i, serverItem);
//                }
//            }
//        }
//
//        System.out.println(".........local 顺序已经排好了........");
//
//        final HashMap<Label, Integer> localTable = new HashMap<>();
//        for (int i = 0; i < local.size(); i++) {
//            localTable.put(local.get(i), i);
//        }
//
//        sort(serverData, new Comparator<Label>() {
//            @Override
//            public int compare(Label o1, Label o2) {
//                return localTable.get(o1) - localTable.get(o2);
//            }
//        }, 2);
//
//        System.out.println("......serverData顺序按照local顺序重排............ ");
//
//        int[] A = new int[]{-1, 1, 6, 2, 3, 4, 5, -2};
//        int[] B = new int[]{4, 3, 2, 1, 0};
//        // 4 3 2 1 5 -1
//        printIntArr(mergeArr(A,B));

        String[] split = "0_455".split("_");
        System.out.println(split.length);

        int index = "0_{dadafd_}".indexOf("_");
        System.out.println("index ======"+index);
    }

    public static <E> void sort(List<E> list, Comparator<? super E> c, int start) {
        Object[] a = list.subList(start, list.size()).toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = list.listIterator();
        int index = 0;
        while (index < start) {
            i.next();
            index++;
        }
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    public static void printIntArr(int[] numbers) {
        if (numbers == null || numbers.length < 1) return;
        for (int num : numbers) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }
}
