package com.util;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;

public class IPv6Util {
	public static boolean isNetwork(String ip) {
		try {
			IPv6Network network = IPv6Network.fromString(ip);
			if (network != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isAddress(String ip) {
		try {
			IPv6Address address = IPv6Address.fromString(ip);
			if (address != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isIP(String ip) {
		try {
			if (isNetwork(ip)) {
				return true;
			} else if (isAddress(ip)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static IPv6Network getNetwork(String ip) {
		try {
			return IPv6Network.fromString(ip);
		} catch (Exception e) {
			return null;
		}
	}

	public static IPv6Address getAddress(String ip) {
		try {
			return IPv6Address.fromString(ip);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean compare(String userIP, String networkIP) {
		try {
			IPv6Address userAddr = IPv6Address.fromString(userIP);
			IPv6Address networkAddr = IPv6Address.fromString(networkIP);

			if (userAddr.compareTo(networkAddr) == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
