# ansible-zfs

A role for installing zfs.


## Actions

- Ensures that zfs is installed (using `apt`)
- Creates zfs volumes.


## Usage:
```
  # This playbook can be run using vagrant (on virtual box). 
  - name: Install zfs
    hosts: zfs
    user: root
  #  connection: local
    
    roles:
      - zfs
```

## License

MIT
