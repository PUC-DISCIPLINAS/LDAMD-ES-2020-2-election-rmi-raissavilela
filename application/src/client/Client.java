package client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Client {
	private String name;
	private String hash;

	public Client(String name, int hash) {
		this.name = name;
		this.hash = hash(name);
	}

	public Client(String name) {
		this.name = name;
		this.hash = hash(name);
	}

	public String name() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String hash(String nome) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(nome.getBytes());
			byte[] md5 = md.digest();
			BigInteger numMd5 = new BigInteger(1, md5);
			String hashMd5 = String.format("%022x", numMd5);
			return hashMd5;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (hash != other.hash)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
