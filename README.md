# krypto-address-validator

A Kotlin library to validate addresses of a variety range of cryptocurrencies

[![](https://jitpack.io/v/stacrypt/krypto-address-validator.svg)](https://jitpack.io/#stacrypt/krypto-address-validator)

### Dependency

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.stacrypt:krypto-address-validator:0.0.1'
	}
	
### How to use

	// Check invalid bitcoin address
    	println(CryptocurrencyAddressValidator("bitcoin").validateAddress("abc1223")) // return false
   
   	// Check valid bitcoin address
   	println(CryptocurrencyAddressValidator(Cryptocurrency.BTC).validateAddress("3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX")) // return true
    
   	// Check bitcoin address on testnet network
   	println(
   		CryptocurrencyAddressValidator("bitcoin").validateAddress(
   		"tb1qqqqqp399et2xygdj5xreqhjjvcmzhxw4aywxecjdzew6hylgvsesrxh6hy",
   		network = BitcoinNetwork.Testnet
   		)
 	) // return true
    
   	// Check tether on BEP20 chain
   	println(
   		CryptocurrencyAddressValidator(Cryptocurrency.USDT).validateAddress(
   		"3MbYQMMmSkC3AgWkj9FMo5LsPTW1zBTwXL",
   		network = TetherNetwork.Mainnet,
   		chainType = TetherChainType.BEP20
   		)
   	) // return true
    
   	// Check tether on ERC20 chain
   	println(
   		CryptocurrencyAddressValidator(Cryptocurrency.USDT).validateAddress(
   		"0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a",
   		network = TetherNetwork.Mainnet,
   		chainType = TetherChainType.ERC20
   		)
   	) // return true

   	// Unsupported currency test
   	println(
   		CryptocurrencyAddressValidator("ABCD").validateAddress(
   		"0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a"
   		)
   	) // throw unsupportedOperationException
