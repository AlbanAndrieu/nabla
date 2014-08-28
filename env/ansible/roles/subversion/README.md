# ansible-subversion

A role for installing subversion.


## Actions

- Ensures that subversion is installed (using `apt`)


## Usage:
```
  - name: Install subversion
    hosts: subversion
    user: root
  #  connection: local
    
    roles:
      - subversion      
```

## License

MIT
