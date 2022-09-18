package com.example.network_app1;

import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleOhosTest
{
    @Test
    public void testBundleName()
    {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.example.network_app1", actualBundleName);
    }
}