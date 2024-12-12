package com.app.test.trans;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionsTest {

    @Test
    public void partitioningBy()
    {
        Map<Boolean, List<Integer>> map =
                IntStream.rangeClosed(1, 10)
                        .boxed()
                        .collect(Collectors.partitioningBy(each -> each % 2 == 0));

        System.out.println(map);

        List<Integer> evens = map.get(true);
        List<Integer> odds = map.get(false);
        List<Integer> ummm = map.get(null);
        List<Integer> ohno = map.get(new Object());

        Assertions.assertEquals(List.of(2, 4, 6, 8, 10), evens);
        Assertions.assertEquals(List.of(1, 3, 5, 7, 9), odds);
        Assertions.assertNull(ummm);
        Assertions.assertNull(ohno);

        ummm = map.getOrDefault(null, evens);
        Assertions.assertEquals(List.of(2, 4, 6, 8, 10), ummm);

        ohno = map.getOrDefault(new Object(), odds);
        Assertions.assertEquals(List.of(1, 3, 5, 7, 9), ohno);
    }

  //  @Test
  /*  public void partition()
    {
        PartitionMutableList<Integer> partition =
                Interval.oneTo(10)
                        .partition(each -> each % 2 == 0);

        MutableList<Integer> selected = partition.getSelected();
        MutableList<Integer> rejected = partition.getRejected();

        Assertions.assertEquals(List.of(2, 4, 6, 8, 10), selected);
        Assertions.assertEquals(List.of(1, 3, 5, 7, 9), rejected);
    }*/
}
